(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest bol-has-spec-basis
  (let [sb (facts/spec-basis "BOL")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["BOL" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["bol.ley-general-del-trabajo"]
         (mapv :statute/id (facts/by-topic "BOL" :labor))))
  (is (= ["bol.cpe-art130-proteccion-privacidad"]
         (mapv :statute/id (facts/by-topic "BOL" :data-protection))))
  (is (empty? (facts/by-topic "BOL" :environment)))
  (is (empty? (facts/by-topic "ATL" :labor))))
