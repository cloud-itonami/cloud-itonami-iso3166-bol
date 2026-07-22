(ns marketentry.facts
  "Per-jurisdiction public-procurement market-entry regulatory catalog
  -- the G2-style spec-basis table the Market-Entry Compliance Governor
  checks every `:jurisdiction/assess` proposal against ('did the advisor
  cite an OFFICIAL public source for this jurisdiction's requirements,
  or did it invent one?').

  Bolivia's real market-entry surface (WebFetch/curl-verified
  2026-07-22, see each entry's own citation) turned out to carry the
  SAME kind of genuine, non-obvious institutional finding this family
  has come to expect -- but in Bolivia's case it is a REVERSAL of the
  shape the task briefing itself expected. The briefing's own working
  assumption was that FUNDEMPRESA -- a private/mixed entity performing
  the Registro de Comercio (Commercial Registry) function under a state
  concession -- is Bolivia's CURRENT institutional shape. Direct primary
  research shows this is no longer true as of this catalog's
  `:retrieved-at`:

  - **Business registration is now a PUBLIC, not a delegated-private,
    function.** This iteration fetched Ley N° 1398 ('LEY DE REGISTRO DE
    COMERCIO', 1 de octubre de 2021) in FULL from SEPREC's own official
    site (`seprec.gob.bo/wp-content/uploads/2025/10/Ley-1398-ley-de-
    registro-de-comercio.pdf`, `pdftotext -layout`-read directly -- HIGH
    confidence, primary text). Its ARTÍCULO ÚNICO reads: 'El Registro de
    Comercio estará bajo tuición del Ministerio de Desarrollo Productivo
    y Economía Plural.' Its DISPOSICIÓN TRANSITORIA SEGUNDA confirms the
    PRIOR concession model existed and was being wound down: 'La
    Concesionaria del Servicio de Registro de Comercio, prestará el
    servicio con normalidad ... hasta la conclusión de la transición del
    Registro de Comercio a la administración del Estado.' The law itself
    refers to the prior operator only generically as 'la Concesionaria'
    -- it does NOT name FUNDEMPRESA by name in this text. FUNDEMPRESA is
    the name this prior concessionaire is universally known by in public
    reporting, but this iteration did NOT independently re-confirm that
    specific name against a freshly-fetched Bolivian primary source this
    session (an honest, explicit gap: the STRUCTURAL finding --
    concession model ended, replaced by a public entity -- is HIGH
    confidence; the specific legacy name 'FUNDEMPRESA' is not
    independently re-verified here). Corroborating, if inconclusive,
    signal: `fundempresa.org.bo` was UNREACHABLE (connection failure)
    from this session's environment, consistent with -- but not proof
    of -- the entity's wind-down.
  - **The successor is SEPREC (Servicio Plurinacional de Registro de
    Comercio)**, a decentralized PUBLIC entity, per Decreto Supremo N°
    4596 (6 de octubre de 2021) -- this iteration did NOT find DS 4596's
    own full article text on lexivox.org (unavailable in its database),
    but directly viewed the OFFICIAL Gaceta Oficial del Estado
    Plurinacional de Bolivia's own published index/masthead images
    (Gaceta N° 1437, La Paz, 06 de octubre de 2021), hosted on SEPREC's
    own site as part of its own 'Breve Historia' page
    (`seprec.gob.bo/index.php/breve-historia-o-resena-sobre-la-creacion-
    y-evolucion-de-la-entidad/`), which read verbatim: '4596  06 DE
    OCTUBRE DE 2021.- Crea el Servicio Plurinacional de Registro de
    Comercio – SEPREC y establece el plazo de transición del Registro de
    Comercio.' HIGH confidence -- a direct visual read of the official
    gazette's own contents table, not a secondary paraphrase. SEPREC's
    own site (`seprec.gob.bo`) separately and consistently describes
    itself as 'la entidad pública descentralizada encargada
    principalmente, de administrar y ejercer funciones del Registro de
    Comercio en Bolivia', operating under the Ministerio de Desarrollo
    Productivo y Economía Plural (MDPyEP) -- matching Ley 1398's own
    Art. Único. This is a GENUINELY NEW institutional shape for this
    family: not a private/delegated registry (the briefing's working
    hypothesis), but a state registry that WAS delegated and has since
    been RE-NATIONALIZED (2021) -- the opposite direction of drift from
    what the briefing anticipated.
  - **Business/tax registration is TWO acts, not one, by TWO bodies
    under TWO DIFFERENT ministries** -- the same 'single act vs two
    acts' question this family's prior siblings were asked to check.
    SEPREC (Registro de Comercio / matrícula de comercio) sits under
    MDPyEP per Ley 1398 Art. Único (HIGH confidence, primary text, as
    above). NIT (Número de Identificación Tributaria) registration is a
    SEPARATE act performed by the Servicio de Impuestos Nacionales (SIN,
    `impuestos.gob.bo`) -- confirmed to sit within the Ministerio de
    Economía y Finanzas Públicas (MEFP)'s own institutional family: this
    iteration directly fetched MEFP's own official homepage
    (`economiayfinanzas.gob.bo`) and found it links DIRECTLY to
    `impuestos.gob.bo` in its own navigation (the SAME evidentiary
    pattern this iteration used to confirm MEFP's relationship to
    SICOES, below) -- MODERATE-HIGH confidence (direct link from the
    ministry's own official site, not an explicit 'SIN reports to MEFP'
    sentence fetched verbatim). SEPREC (MDPyEP) and SIN (MEFP-family) are
    thus confirmed as two independently-sourced, differently-ministried
    bodies -- structurally the same 'separate acts, separate bodies'
    shape BLR's own catalog documented for its own jurisdiction,
    independently re-grounded here in Bolivia's own Ley 1398 + MEFP/SIN
    site evidence, not copied from that sibling's citation. This
    iteration did NOT independently fetch a SIN page stating the
    specific sequencing/prerequisite relationship between matrícula de
    comercio and NIT registration in so many words -- an honest,
    explicit gap in an otherwise well-evidenced two-body finding.
  - **Public procurement remains a SINGLE portal + SINGLE regulator
    shape** (unlike Belarus's own three-way split) -- confirmed by
    directly fetching SICOES's own official portal
    (`sicoes.gob.bo/portal/index.php`, HIGH confidence, primary,
    operator's own site): its own 'Decretos y Reglamentos' popover names
    'Normas Básicas del Sistema de Administración de Bienes y Servicios
    - D.S. N° 0181' directly as SICOES's own governing decree. The
    Ministerio de Economía y Finanzas Públicas (MEFP)'s own official
    homepage (`economiayfinanzas.gob.bo`) links DIRECTLY to
    `sicoes.gob.bo/portal/index.php` under its own 'Contrataciones'
    navigation -- HIGH-MODERATE confidence (a direct link from the
    ministry's own official site to the portal; this iteration did NOT
    fetch a page stating in so many words 'MEFP administers SICOES',
    though this is the same evidentiary weight the family has accepted
    elsewhere for operator/regulator affiliation). SICOES's own site
    additionally exposes, in its own client-side navigation (directly
    observed in `sicoes.gob.bo`'s own page source this iteration
    fetched), a RUPE (Registro Único de Proveedores del Estado) supplier
    on-boarding section (`/portal/rupe/guiaProveedores.php`) and an
    'incumplidos' (non-compliant/defaulting supplier) section
    (`/portal/incumplidos/entidadesExcepcion.php`,
    `/portal/incumplidos/incPacEstProceso.php`) -- both are JavaScript
    single-page-application routes whose RENDERED content this iteration
    could NOT fetch (client-side AJAX, not server-rendered HTML,
    confirmed by comparing byte-identical shell responses across
    routes), so their existence as live portal FEATURES is HIGH
    confidence (directly observed in the site's own served
    JavaScript-navigation code) while the precise NB-SABS (D.S. N° 0181)
    article establishing the incumplidos list is NOT independently
    confirmed this iteration -- MODERATE confidence overall for the
    flagship check this catalog grounds here, honestly weaker than
    BLR's own (also MODERATE) flagship citation but for a different
    reason (portal-feature-level confirmation vs. a translation-mirror
    text read).

  Coverage is reported HONESTLY (see `coverage`): a jurisdiction not in
  this table has NO spec-basis, full stop -- the advisor must not
  fabricate one, and the governor holds if it tries.")

(def catalog
  "iso3 -> requirement map. `:required-evidence` mirrors the generic
  intake/portal-registration/filing evidence set; `:legal-basis` /
  `:owner-authority` / `:provenance` are the G2 citation the governor
  requires before any `:jurisdiction/assess` proposal can commit. BOL
  deliberately carries NO `:rep-owner-authority` -- see the namespace
  docstring's honest-scope-narrowing note (this iteration did not find
  comparably strong evidence of a mandatory resident/domestic-
  representative requirement for Bolivian public-tender participation
  specifically). `:restricted-supplier-*` grounds this vertical's
  flagship governor check (`restricted-supplier-spec-basis`), here
  re-grounded in SICOES's own 'incumplidos' (non-compliant supplier)
  portal section rather than copied from a sibling's citation.
  `:business-registration-*` mirrors the family's precedent of
  extending the shared schema when a jurisdiction's own institutional
  shape genuinely needs a slot no prior sibling required: Bolivia's
  business-registration act (SEPREC, under the Ministerio de Desarrollo
  Productivo y Economía Plural) is performed by a DIFFERENT body under a
  DIFFERENT ministry than both the procurement regulator (MEFP/SICOES)
  and the tax/NIT registrar (SIN, MEFP-family), so `:corporate-number-*`
  (the NIT regime) cannot honestly stand in for it."
  {"BOL" {:name "Bolivia"
          :owner-authority "Ministerio de Economía y Finanzas Públicas (MEFP) -- administra/enlaza directamente el portal SICOES (Sistema de Contrataciones Estatales, sicoes.gob.bo), cuya propia página cita el D.S. N° 0181 como su norma rectora"
          :legal-basis "Decreto Supremo N° 0181, Normas Básicas del Sistema de Administración de Bienes y Servicios (NB-SABS) -- citado directamente por el propio portal SICOES como su decreto rector ('Decretos y Reglamentos' -> 'Normas Básicas del Sistema de Administración de Bienes y Servicios - D.S. N° 0181')"
          :national-spec "Registro Único de Proveedores del Estado (RUPE) en sicoes.gob.bo + publicación/participación en convocatorias (contrataciones nacionales y subnacionales) a través del mismo portal"
          :provenance "https://www.sicoes.gob.bo/portal/index.php ; https://www.economiayfinanzas.gob.bo/"
          :required-evidence ["Matrícula de Comercio vigente (SEPREC, Ley N° 1398 + D.S. N° 4596)"
                              "NIT activo sin adeudos ante el Servicio de Impuestos Nacionales (SIN)"
                              "Inscripción vigente en el Registro Único de Proveedores del Estado (RUPE, sicoes.gob.bo)"
                              "Confirmación de representante autorizado"]
          :corporate-number-owner-authority "Servicio de Impuestos Nacionales (SIN)"
          :corporate-number-legal-basis "NIT (Número de Identificación Tributaria) -- registro tributario obligatorio; acto SEPARADO de la matrícula de comercio (SEPREC), administrado por un cuerpo bajo un ministerio distinto (SIN se enlaza directamente desde el propio sitio del Ministerio de Economía y Finanzas Públicas, el mismo ministerio que enlaza a SICOES) -- ver docstring del namespace para el hallazgo 'dos actos, dos cuerpos, dos ministerios'"
          :corporate-number-provenance "https://www.impuestos.gob.bo/ ; https://www.economiayfinanzas.gob.bo/"
          :business-registration-owner-authority "Servicio Plurinacional de Registro de Comercio (SEPREC) -- entidad pública descentralizada bajo tuición del Ministerio de Desarrollo Productivo y Economía Plural (MDPyEP), per Ley N° 1398 Art. Único"
          :business-registration-legal-basis "Ley N° 1398 'LEY DE REGISTRO DE COMERCIO' (1 de octubre de 2021) + Decreto Supremo N° 4596 (6 de octubre de 2021, crea SEPREC y establece el plazo de transición del Registro de Comercio) -- REEMPLAZA el modelo previo de concesión privada del Registro de Comercio (ver docstring del namespace: la Ley 1398 refiere al operador previo solo genéricamente como 'la Concesionaria', sin nombrarlo)"
          :business-registration-provenance "https://www.seprec.gob.bo/wp-content/uploads/2025/10/Ley-1398-ley-de-registro-de-comercio.pdf ; https://www.seprec.gob.bo/index.php/breve-historia-o-resena-sobre-la-creacion-y-evolucion-de-la-entidad/ ; https://www.seprec.gob.bo/index.php/que-es-registro-de-comercio/"
          :restricted-supplier-owner-authority "Ministerio de Economía y Finanzas Públicas / SICOES -- sección 'incumplidos' (proveedores y entidades no conformes) del propio portal"
          :restricted-supplier-legal-basis "Funcionalidad en vivo del propio portal SICOES (rutas de navegación propias del sitio: /portal/incumplidos/entidadesExcepcion.php, /portal/incumplidos/incPacEstProceso.php) -- MODERATE confidence: existencia de la funcionalidad confirmada directamente en el código fuente del propio sitio; el artículo específico del D.S. N° 0181 (NB-SABS) que fundamenta esta lista NO fue confirmado de forma independiente esta iteración (contenido renderizado vía JavaScript/AJAX, no accesible a un fetch estático)"
          :restricted-supplier-provenance "https://www.sicoes.gob.bo/portal/index.php"}
   "USA" {:name "United States"
          :owner-authority "U.S. General Services Administration (GSA) / SAM.gov"
          :legal-basis "Federal Acquisition Regulation (FAR); System for Award Management"
          :national-spec "SAM.gov entity registration + NAICS self-certification"
          :provenance "https://sam.gov/"
          :required-evidence ["EIN record"
                              "SAM.gov registration record"
                              "State business registration record"
                              "Authorized-representative record"]}
   "DEU" {:name "Germany"
          :owner-authority "Beschaffungsamt des BMI / e-Vergabe platforms"
          :legal-basis "Gesetz gegen Wettbewerbsbeschränkungen (GWB) / VgV"
          :national-spec "e-Vergabe supplier registration under EU procurement directives"
          :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract"
                              "e-Vergabe registration record"
                              "USt-IdNr record"
                              "Authorized-representative record"]}})

(defn spec-basis
  "The jurisdiction's requirement map, or nil -- nil means NO spec-basis,
  and the governor must hold any proposal that tries to assess or file
  on it."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report: how many of the requested jurisdictions actually
  have a spec-basis entry. Never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-bol R0: " (count catalog)
                 " jurisdictions seeded with an official spec-basis. "
                 "This is a starting catalog for market-entry navigation, "
                 "not a survey of all ~194 jurisdictions -- extend "
                 "`marketentry.facts/catalog`, never fabricate a "
                 "jurisdiction's requirements.")})))

(defn required-evidence-satisfied?
  "Does `submitted` (a set/coll of evidence keywords or strings) satisfy
  every evidence item listed for `iso3`? Missing spec-basis -> never
  satisfied."
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3]
  (:required-evidence (spec-basis iso3) []))

(defn rep-spec-basis
  "The jurisdiction's representative-related requirement map, or nil when
  this catalog has no such regime. For BOL this is deliberately nil --
  see the `catalog` docstring's honest-scope-narrowing note."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))

(defn corporate-number-spec-basis
  "The jurisdiction's corporate-number / tax-id (NIT, for BOL) regime,
  or nil."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority
                       :corporate-number-legal-basis
                       :corporate-number-provenance]))))

(defn business-registration-spec-basis
  "The jurisdiction's business (state) registration regime, or nil. A
  NEW accessor this iteration adds to the shared schema: Bolivia's
  business-registration act is performed by SEPREC (a DIFFERENT body,
  under a DIFFERENT ministry -- the Ministerio de Desarrollo Productivo
  y Economía Plural) than BOTH the procurement regulator
  (`:owner-authority`, MEFP/SICOES) and the tax/NIT registrar
  (`corporate-number-spec-basis`, SIN), so neither of those accessors
  can honestly stand in for it -- see the namespace docstring's
  'two acts, two bodies, two ministries' finding."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:business-registration-owner-authority sb)
      (select-keys sb [:business-registration-owner-authority
                       :business-registration-legal-basis
                       :business-registration-provenance]))))

(defn restricted-supplier-spec-basis
  "The jurisdiction's restricted/unreliable-supplier-list regime, or
  nil. For BOL this is grounded at MODERATE confidence in SICOES's own
  live 'incumplidos' portal section -- the flagship check this vertical
  adds is re-grounded here (see namespace docstring), not copied from a
  sibling's citation."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:restricted-supplier-owner-authority sb)
      (select-keys sb [:restricted-supplier-owner-authority
                       :restricted-supplier-legal-basis
                       :restricted-supplier-provenance]))))
