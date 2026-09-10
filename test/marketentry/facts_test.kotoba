(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest bol-has-spec-basis
  (let [sb (facts/spec-basis "BOL")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/corporate-number-spec-basis "BOL")))
    (is (some? (facts/business-registration-spec-basis "BOL")))
    (is (some? (facts/restricted-supplier-spec-basis "BOL")))))

(deftest bol-rep-spec-basis-is-honestly-absent
  (testing "no verified resident/domestic-representative mandate for BOL public-procurement participation -- deliberately not claimed"
    (is (nil? (facts/rep-spec-basis "BOL")))))

(deftest bol-business-registration-is-a-separate-body-from-tax-and-procurement
  (testing "business registration (SEPREC, under MDPyEP) is a DIFFERENT body under a DIFFERENT ministry than the tax/NIT registrar (SIN) and the procurement regulator (MEFP) -- see namespace docstring 'two acts, two bodies, two ministries' finding"
    (let [reg (facts/business-registration-spec-basis "BOL")
          tax (facts/corporate-number-spec-basis "BOL")]
      (is (some? reg))
      (is (some? tax))
      (is (not= (:business-registration-owner-authority reg)
                (:corporate-number-owner-authority tax))))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ")))
  (is (nil? (facts/business-registration-spec-basis "ATL")))
  (is (nil? (facts/restricted-supplier-spec-basis "ATL"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "BOL")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "BOL" all)))
    (is (not (facts/required-evidence-satisfied? "BOL" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest fundempresa-is-a-stale-business-registration-authority
  (testing "FUNDEMPRESA (wound down 2021, replaced by SEPREC) must never be treated as current"
    (is (true? (facts/stale-business-registration-authority? "FUNDEMPRESA")))
    (is (true? (facts/stale-business-registration-authority? "Fundempresa")))
    (is (false? (facts/stale-business-registration-authority? "SEPREC")))
    (is (false? (facts/stale-business-registration-authority? nil)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["BOL" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 2 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))
