(ns statute.facts
  "General-law compliance catalog for Bolivia (BOL) -- extends this
  repo's existing `marketentry.facts` (public-procurement market-entry
  only, narrow scope) with a second, orthogonal catalog of statutes a
  company operating in this jurisdiction must generally track for
  compliance. Mirrors cloud-itonami-iso3166-aze/-bih/-jpn/-deu/-bgr/-blr's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Every entry below cites an OFFICIAL Bolivian source, WebFetch/curl-
  verified 2026-07-22, and every citation reflects content this
  iteration actually fetched and read, not a secondary summary --
  confidence stated per-claim, not per-citation:

  - **Código de Comercio de Bolivia** (Commercial Code) -- Bolivia's own
    primary-source repositories (lexivox.org) did NOT have Decreto Ley
    N° 14379 in their database this iteration ('Norma inexistente en la
    base de datos'). The citation instead comes from WIPO Lex (a WIPO/UN
    treaty-body-maintained legal database, MODERATE confidence -- an
    international secondary source, not Bolivia's own gazette text),
    which gives 'Decreto Ley N° 14379, de 25 de febrero de 1977, en
    vigor desde el 1 de enero de 1978'. This is independently
    corroborated (HIGH confidence for the fact of citation, if not the
    exact decree number/date) by SEPREC's own official site
    (`seprec.gob.bo/index.php/que-es-registro-de-comercio/`), which
    names 'Código de Comercio' as ITS OWN legal foundation for the
    Registro de Comercio, alongside Ley N° 779 (Desburocratización) and
    Ley N° 947 (micro and small enterprises) -- both of which this
    iteration did NOT independently fetch/verify in full (an honest,
    explicit gap, not a claim of full coverage of Bolivia's
    business-formalization statute stack).
  - **Ley General del Trabajo** -- fetched directly from lexivox.org
    (`BO-L-19390524.html`), which hosts the law under its ORIGINAL
    issuance date, 24 de mayo de 1939 (Decreto Supremo, later widely
    cited in secondary sources -- e.g. a PDF titled 'Ley general del
    trabajo del 8 de diciembre de 1942' hosted by a Bolivian public
    university, Universidad Autónoma Juan Misael Saracho -- as having
    been 'elevada a rango de Ley' on 8 de diciembre de 1942). This
    iteration independently fetched and read the 1939 primary text
    (Art. 1 scope clause confirmed verbatim) -- HIGH confidence for the
    law's existence, original date, and Art. 1 text. The 8-December-1942
    elevation-to-Law date is MODERATE confidence -- cited in secondary
    sources this iteration observed but the elevating Ley's own text was
    NOT independently fetched this session. Currency/enforcement is
    independently corroborated (HIGH confidence) by the Ministerio de
    Trabajo, Empleo y Previsión Social's OWN official site
    (`mintrabajo.gob.bo`), whose own stated institutional objective is
    to 'Velar por la aplicación y el cumplimiento de la Ley General de
    Trabajo, Ley de Cooperativas y disposiciones conexas' -- i.e. the
    ministry itself currently names this as its own governing statute.
    The Ley General del Trabajo's own amendment chain (decades of
    Decretos Supremos and Decretos Reglamentarios since 1939/1942) is
    honestly NOT traced here -- explicitly too complex for this
    iteration's time budget, mirroring the same honest scoping BLR's own
    Labour Code entry used for its own amendment chain.
  - **Personal data protection -- deliberately NOT claimed as a
    comprehensive law.** This iteration explicitly checked rather than
    assumed (per this catalog's own standing discipline) whether Bolivia
    has a comprehensive, currently-enacted personal-data-protection
    statute, and the honest answer is NO, not yet: Bolivia's OWN
    e-government agency, AGETIC (Agencia de Gobierno Electrónico y
    Tecnologías de Información y Comunicación, `agetic.gob.bo`),
    published a press item (dated 14 May 2026, i.e. recent, within this
    catalog's own `:retrieved-at` window) titled 'AGETIC impulsa Ley de
    Protección de Datos con apoyo del BID y el Legislativo' -- AGETIC is
    itself still PROMOTING/pushing a draft law with Inter-American
    Development Bank support, not administering an enacted one. This is
    independently corroborated by DLA Piper's international 'Data
    Protection Laws of the World' survey (a reputable secondary/tertiary
    source, MODERATE confidence for its specific legal-detail claims),
    which states Bolivia lacks comprehensive data-protection legislation
    (draft under discussion since 2023) and instead relies on: (a) Art.
    130 of the Constitución Política del Estado (Acción de Protección de
    Privacidad / habeas data), and (b) sector-specific telecom rules the
    survey attributes to Decretos Supremos N° 1391 and N° 1793. This
    iteration independently fetched BOTH DS 1391 and DS 1793's full text
    from lexivox.org and could NOT locate any 'datos personales' /
    'consentimiento' clause in either -- DS 1391 (24.10.2012) is the
    General Regulation to Ley N° 164 (Ley General de Telecomunicaciones,
    TIC) and DS 1793 (13.11.2013) is the ICT-development regulation
    (digital signatures, FLOSS adoption, e-government) under the SAME
    Ley N° 164 -- neither's fetched text corroborated DLA Piper's
    specific consent-requirement claim. Rather than force-fit an
    unverified sector-specific citation, this iteration OMITS the
    telecom-sector claim entirely and instead cites only what it
    independently confirmed in full primary text: Art. 130 CPE itself
    (fetched from lexivox.org's own CPE text, `BO-CPE-20090207.html`;
    the 'Acción de Protección de Privacidad' section heading and its
    Art. 21(2)/Art. 25 neighboring privacy provisions were directly
    confirmed, though the exact Art. 130 body text was truncated in this
    session's fetch -- HIGH confidence for the article's existence/topic,
    not a claim of verbatim full-text reproduction). This is a
    CONSTITUTIONAL habeas-data mechanism, NOT a comprehensive statutory
    data-protection regime -- `marketentry.facts` and this catalog both
    must not be read as claiming Bolivia has GDPR-style comprehensive
    data-protection law; it does not, as of this catalog's
    `:retrieved-at`.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"BOL"
   [{:statute/id "bol.commercial-code"
     :statute/title "Código de Comercio de Bolivia (Commercial Code of Bolivia)"
     :statute/jurisdiction "BOL"
     :statute/kind :law
     :statute/law-number "Decreto Ley N° 14379, promulgado el 25 de febrero de 1977, en vigencia desde el 1 de enero de 1978 (citación vía WIPO Lex -- MODERATE confidence, no confirmado esta iteración contra el texto de la Gaceta Oficial boliviana; independientemente corroborado como fundamento del Registro de Comercio por el propio sitio de SEPREC)"
     :statute/url "https://www.wipo.int/wipolex/en/members/profile/BO"
     :statute/url-provenance :wipo-lex-secondary
     :statute/enacted-date "1977-02-25"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "bol.ley-general-del-trabajo"
     :statute/title "Ley General del Trabajo (Bolivia)"
     :statute/jurisdiction "BOL"
     :statute/kind :law
     :statute/law-number "Emitida originalmente como Decreto Supremo el 24 de mayo de 1939; ampliamente citada en fuentes secundarias como elevada a rango de Ley el 8 de diciembre de 1942 (fecha de elevación NO confirmada de forma independiente esta iteración mediante el texto primario de la Ley elevatoria); vigente, con una cadena de decretos supremos y reglamentarios modificatorios que esta iteración NO intentó trazar en su totalidad -- ver docstring del namespace"
     :statute/url "https://www.lexivox.org/norms/BO-L-19390524.html"
     :statute/url-provenance :lexivox-mirror
     :statute/enacted-date "1939-05-24"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:labor :employment}}
    {:statute/id "bol.cpe-art130-proteccion-privacidad"
     :statute/title "Constitución Política del Estado, Artículo 130 -- Acción de Protección de Privacidad (habeas data)"
     :statute/jurisdiction "BOL"
     :statute/kind :constitutional-provision
     :statute/law-number "Constitución Política del Estado, promulgada el 7 de febrero de 2009, Sección III 'Acción de Protección de Privacidad', Art. 130 -- CONSTITUTIONAL habeas-data mechanism, NOT a comprehensive statutory personal-data-protection law (Bolivia does not yet have one -- see namespace docstring)"
     :statute/url "https://www.lexivox.org/norms/BO-CPE-20090207.html"
     :statute/url-provenance :lexivox-mirror
     :statute/enacted-date "2009-02-07"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-bol statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "BOL")) " BOL statutes seeded with an "
                 "official-or-corroborated citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :data-protection)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
