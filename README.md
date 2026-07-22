# cloud-itonami-iso3166-bol

Open ISO 3166 Blueprint for **BOL**: Bolivia. **`:implemented`** --
`src/marketentry/*` is a running langgraph-clj StateGraph actor: a
MarketEntry-LLM advisor sealed behind an independent Market-Entry
Compliance Governor. Flagship check `stale-business-registration-
authority` (catches an LLM citing the wound-down FUNDEMPRESA private
concession instead of the current public registrar SEPREC) plus
`incumplido-listed` (SICOES 'incumplidos' non-compliant-supplier-list
membership) and `nit-unverified` (SIN tax registration).

```
clojure -M:dev:test
```

This repository designs **and implements** a forkable OSS business for an independent
public-sector market-entry consultant: an already-incorporated operator
(e.g. a `cloud-itonami-cofog-{code}`, `cloud-itonami-isco-{code}`,
`cloud-itonami-unspsc-{segment}` or `cloud-itonami-{ISIC}` blueprint
fork) gets a Compliance Advisor + independent **Market-Entry Compliance
Governor** to navigate public-procurement registration, local business/
tax registration, and local-content rules in Bolivia, so the operator
can win and service a government contract without hiring a full in-house
compliance department.

## No robotics premise — digital/data service exemption

Market-entry and procurement-compliance navigation is a pure data/software
service with no physical-domain work (portal registration, document
checklists, regulatory-change monitoring) — the same exemption class as
`cloud-itonami-6310` (HR SaaS replacement) and `cloud-itonami-gtin-*`.
`blueprint.edn` sets `:itonami.blueprint/robotics false` and
`:required-technologies` lists only real capabilities (`:identity`,
`:forms`, `:dmn`, `:bpmn`, `:audit-ledger`), no `:robotics`.

## Core Contract

```text
operator intake + prior filing history
        |
        v
Compliance Advisor -> Market-Entry Compliance Governor -> filing draft, or human sign-off
        |
        v
gated portal registration / filing submission + audit ledger
```

No automated proposal can submit a portal registration or filing the
governor refuses, suppress a compliance record, or claim a legal/tax
conclusion the governor has not cleared. `:filing/submit` is never in any
phase's `:auto` set — it always requires human sign-off (mirrors
`cloud-itonami-M6910`'s `filing-submit-never-auto-at-any-phase`
invariant).

## Governor checks

`marketentry.governor/check` runs every proposal through these HARD
checks (a human approver cannot override a HARD violation) before the
confidence-floor / actuation gate. Each check's regulatory fact is
`marketentry.facts`-cited; source URLs below were fetched and verified
this session, not invented:

| Check | Fires on | Source |
|---|---|---|
| `no-spec-basis` | any `jurisdiction/assess`\|`filing/draft`\|`filing/submit` proposal that doesn't cite an official source | n/a (structural) |
| `stale-business-registration-authority` **(flagship, currency trap)** | a proposal citing **FUNDEMPRESA** as the current business-registration authority -- FUNDEMPRESA operated the Registro de Comercio under a private concession model that Ley N° 1398 (1 de octubre de 2021) + Decreto Supremo N° 4596 (6 de octubre de 2021) wound down, transferring the function to the public entity **SEPREC** | https://www.seprec.gob.bo/wp-content/uploads/2025/10/Ley-1398-ley-de-registro-de-comercio.pdf ; https://www.seprec.gob.bo/index.php/breve-historia-o-resena-sobre-la-creacion-y-evolucion-de-la-entidad/ |
| `evidence-incomplete` | `filing/draft`\|`filing/submit` before the jurisdiction's full evidence checklist (Matrícula de Comercio vigente / NIT activo / RUPE registration / authorized-representative confirmation) is on file | https://www.sicoes.gob.bo/portal/index.php ; https://www.impuestos.gob.bo/ |
| `incumplido-listed` **(unconditional, per-submit)** | `filing/submit` where the engagement's own declared `:on-incumplidos-list?` is true -- SICOES's own live 'incumplidos' (non-compliant/defaulting supplier) portal section is a categorical bar to further participation | https://www.sicoes.gob.bo/portal/index.php (MODERATE confidence -- portal-feature-level, the specific NB-SABS article was not independently confirmed) |
| `engagement-fee-mismatch` | `filing/submit` where `:claimed-fee` ≠ independently recomputed `base-fee + monthly-rate x monitoring-months` | n/a (arithmetic) |
| `nit-unverified` | `filing/submit` where `:requires-nit?` is true but `:nit-verified?` is false -- NIT (Número de Identificación Tributaria) is a SEPARATE act performed by the Servicio de Impuestos Nacionales (SIN), a different body under a different ministry than SEPREC | https://www.impuestos.gob.bo/ |
| `already-drafted` / `already-submitted` | a second `filing/draft`/`filing/submit` for the same engagement | n/a (structural, off dedicated `:drafted?`/`:submitted?` facts) |

Public procurement itself is governed by SICOES (Sistema de
Contrataciones Estatales, sicoes.gob.bo), whose own site names NB-SABS
(Normas Básicas del Sistema de Administración de Bienes y Servicios,
Decreto Supremo N° 0181) as its governing decree -- source:
https://www.sicoes.gob.bo/portal/index.php. Owner-authority is modeled
at the ministry level (Ministerio de Economía y Finanzas Públicas, MEFP)
rather than a specific internal directorate, matching this family's
no-fabricated-directorate discipline.

### SEPREC / FUNDEMPRESA currency distinction

Bolivia's business (commercial) registration function is **NOT** what
an LLM's training data likely says. FUNDEMPRESA -- a private/mixed
entity that performed the Registro de Comercio function under a state
concession -- was wound down starting 2021: Ley N° 1398 "Ley de
Registro de Comercio" (1 de octubre de 2021) + Decreto Supremo N° 4596
(6 de octubre de 2021, "Crea el Servicio Plurinacional de Registro de
Comercio – SEPREC y establece el plazo de transición del Registro de
Comercio") transferred the function to **SEPREC** (Servicio
Plurinacional de Registro de Comercio), a decentralized PUBLIC entity
under the Ministerio de Desarrollo Productivo y Economía Plural
(MDPyEP) -- the OPPOSITE direction of drift from a private-delegation
model. `marketentry.facts/business-registration-authority-deprecated`
names FUNDEMPRESA explicitly so `marketentry.governor`'s
`spec-basis-violations` HARD-holds any proposal that cites it as
current, regardless of confidence -- see `test/marketentry/
governor_contract_test.clj`'s `stale-business-registration-authority-
is-held-and-unoverridable` / `fresh-assess-cites-seprec-not-
fundempresa`. This mirrors the exact currency-trap discipline
`cloud-itonami-iso3166-isl` applies to the decommissioned Ríkiskaup
(superseded by Fjársýslan/FMA).

## Actuation

`:filing/draft` and `:filing/submit` are the two real-world acts this
actor performs (preparing a portal registration package, and actually
submitting one on sicoes.gob.bo/RUPE). Two independent layers agree
neither ever auto-commits:

- **`marketentry.phase`**: `:filing/draft`/`:filing/submit` are
  permanently absent from every rollout phase's `:auto` set (phase
  0 through 3) — not a rollout milestone still to come, a structural
  fact.
- **`marketentry.governor`**: both ops carry
  `:stake :actuation/draft-filing`/`:actuation/submit-filing`, members
  of `governor/high-stakes`, which forces `:escalate?` even when the
  proposal is otherwise clean.

Every `filing/draft`/`filing/submit` therefore always reaches
`operation.cljc`'s `:request-approval` node
(`interrupt-before #{:request-approval}`) and pauses for a real human
market-entry operator's sign-off — see `test/marketentry/
governor_contract_test.clj`'s `draft-always-escalates-then-human-
decides` / `submit-always-escalates-then-human-decides`.

## What this is NOT

- **Not the government of Bolivia.** See
  [`docs/business-model.md`](docs/business-model.md) for the boundary with
  `com-etzhayyim-ooyake` (read-only civic mirror), `matsurigoto` (sovereign
  statecraft), `com-etzhayyim-toritsugi` (individual citizen concierge),
  `legal-entity.etzhayyim.com` (read-only data aggregation), and
  `cloud-itonami-M6910` (company incorporation — a different regulatory
  phase this blueprint assumes is already complete).
- **Not legal or tax advice.** Every regulatory claim must cite the
  official source and route final filings to Bolivian-licensed counsel
  or a registered agent where the law requires licensed representation.

## Capability layer

Resolves via [`kotoba-lang/iso3166`](https://github.com/kotoba-lang/iso3166)
(ISO 3166 `BOL`). Required capabilities:

- :identity
- :forms
- :dmn
- :bpmn
- :audit-ledger

See [`docs/business-model.md`](docs/business-model.md) and
[`docs/operator-guide.md`](docs/operator-guide.md).

## License

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Bolivia:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
