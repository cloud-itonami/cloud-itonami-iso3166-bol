(ns culture.facts
  "Country-level regional-culture catalog for Bolivia (BOL) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"BOL"
   [{:culture/id "bol.dish.saltena"
     :culture/name "Salteña"
     :culture/country "BOL"
     :culture/kind :dish
     :culture/summary "Bolivian type of baked empanada filled with beef, pork or chicken in a sweet, slightly spicy, juicy gelatin-based stew; found in any town or city throughout the country, traditionally as a mid-morning snack."
     :culture/url "https://en.wikipedia.org/wiki/Salte%C3%B1a"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.dish.pique-macho"
     :culture/name "Pique macho"
     :culture/country "BOL"
     :culture/kind :dish
     :culture/summary "Bolivian dish of beef, sausage, red onion, green pepper, tomato and french fries that originated in the Cochabamba Department in the mid-1970s; one of the country's most popular dishes."
     :culture/url "https://en.wikipedia.org/wiki/Pique_macho"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.dish.silpancho"
     :culture/name "Silpancho"
     :culture/name-local "Sillp'anchu"
     :culture/country "BOL"
     :culture/kind :dish
     :culture/summary "Popular Bolivian food from the city of Cochabamba: a base layer of rice, boiled and sliced potatoes, a thin layer of pounded meat and chopped tomato."
     :culture/url "https://en.wikipedia.org/wiki/Silpancho"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.beverage.singani"
     :culture/name "Singani"
     :culture/country "BOL"
     :culture/kind :beverage
     :culture/summary "Bolivian brandy distilled from Muscat of Alexandria grapes grown at 1,600 m or higher; the country's national distilled spirit, considered part of its cultural patrimony and protected as a geographical indication."
     :culture/url "https://en.wikipedia.org/wiki/Singani"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.product.chuno"
     :culture/name "Chuño"
     :culture/country "BOL"
     :culture/kind :product
     :culture/summary "Preserved potato product traditionally made by Quechua and Aymara communities of Bolivia and Peru through natural freeze-drying in the Andean Altiplano; predates the Inca Empire."
     :culture/url "https://en.wikipedia.org/wiki/Chu%C3%B1o"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.festival.carnaval-de-oruro"
     :culture/name "Carnival of Oruro"
     :culture/name-local "Carnaval de Oruro"
     :culture/country "BOL"
     :culture/kind :festival
     :culture/summary "Religious and cultural festival in Oruro, Bolivia blending indigenous traditions with devotion to the Virgin of Socavón; proclaimed a UNESCO Masterpiece of the Oral and Intangible Heritage of Humanity in 2001."
     :culture/url "https://en.wikipedia.org/wiki/Carnaval_de_Oruro"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.heritage.tiwanaku"
     :culture/name "Tiwanaku"
     :culture/country "BOL"
     :culture/kind :heritage
     :culture/summary "Pre-Columbian archaeological site in western Bolivia near Lake Titicaca, spiritual and political centre of the Tiwanaku culture; designated a UNESCO World Heritage Site in 2000."
     :culture/url "https://en.wikipedia.org/wiki/Tiwanaku"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bol.heritage.potosi"
     :culture/name "City of Potosí"
     :culture/name-local "Potosí"
     :culture/country "BOL"
     :culture/kind :heritage
     :culture/summary "High-altitude Bolivian mining city whose Cerro Rico produced an estimated 60% of all silver mined in the world in the second half of the 16th century; a UNESCO World Heritage Site since 1987."
     :culture/url "https://en.wikipedia.org/wiki/Potos%C3%AD"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-bol culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "BOL"))
                 " BOL entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
