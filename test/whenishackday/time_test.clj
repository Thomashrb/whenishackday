(ns whenishackday.time-test
  (:require [clojure.test :refer :all]
            [whenishackday.time :as time]))

(deftest test-last-friday
  (testing "last-friday returns the correct data for 2021 06"
    (is (= (time/last-friday-day 2021 6) 25)))
  (testing "last-friday returns the correct data for 2021 07"
    (is (= (time/last-friday-day 2021 7) 30))))

(deftest test-inc-date
  (testing "inc-date returns a date with incremented year when month is 12"
    (is (= (time/inc-date 2021 12) [2022 1])))
  (testing "inc-date returns a date with incremented month when month is 11"
    (is (= (time/inc-date 2021 11) [2021 12]))))
