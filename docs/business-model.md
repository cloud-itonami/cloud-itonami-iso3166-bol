# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Bolivia

## Classification

- Repository: `cloud-itonami-iso3166-bol`
- ISO 3166: `BOL` (Bolivia)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:bolivian-sme-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Bolivian
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  Bolivia for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation and
  now needs public-sector market access

## Offer

- registration walkthrough for SICOES (Sistema de Contrataciones
  Estatales, sicoes.gob.bo), Bolivia's centralized public-procurement
  publication portal managed by the Ministry of Economy and Public
  Finance, covering goods, services, works and consulting contracts
  from national and subnational entities
- business/tax registration checklist: an active NIT (Número de
  Identificación Tributaria) with no outstanding debt to the SIN
  (Servicio de Impuestos Nacionales), a SEPARATE act from commercial
  registration; commercial registration via SEPREC (Servicio
  Plurinacional de Registro de Comercio), the decentralized public
  entity that replaced the prior private concession model in 2021 per
  Ley N° 1398 "Ley de Registro de Comercio" (1 de octubre de 2021) and
  Decreto Supremo N° 4596 (6 de octubre de 2021, "Crea el Servicio
  Plurinacional de Registro de Comercio – SEPREC y establece el plazo
  de transición del Registro de Comercio") -- corrected 2026-07-22;
  see `src/marketentry/facts.cljc` and `src/statute/facts.cljc` for the
  full citation trail (a prior draft of this document cited "Supreme
  Decree 4644", which this iteration could not verify and replaces
  with the directly-fetched DS N° 4596 citation)
- local-content / preferential-procurement navigation: Bolivian
  public-procurement preference provisions on qualifying tenders
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Bolivian-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Bolivia).
