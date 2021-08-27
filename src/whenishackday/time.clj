(ns whenishackday.time
  (:import (java.time LocalDate)
           (java.time.temporal TemporalAdjusters)
           (java.time DayOfWeek)
           (java.lang Math)))

(defn- today-day
  "Return todays day of the month"
  []
  (.. (LocalDate/now)
      (getDayOfMonth)))

(defn- today-month
  "Return todays month"
  []
  (.. (LocalDate/now)
      (getMonthValue)))

(defn- today-year
  "Return todays year"
  []
  (.. (LocalDate/now)
      (getYear)))

(defn last-friday-day
  "Find the last friday of a month and return its day of month"
  [year month]
  (.. (LocalDate/of year month 1)
      (with (TemporalAdjusters/lastInMonth DayOfWeek/FRIDAY))
      (getDayOfMonth)))

(defn inc-date
  "Increment a month accounting for month/year overflow
  and return a [year month] vector"
  [year month]
  (let [next-month (if (> 12 month) (inc month) 1)
        next-year (if (> 12 month) year (inc year))]
    [next-year next-month]))

(defn nexthackday-day-count
  "Find the number of days until the next hackday"
  []
  (let [month (today-month)
        year (today-year)
        count (- (last-friday-day year month) (today-day))]
    (if (<= 0 count)
      count
      (+ (Math/abs count) (apply last-friday-day (inc-date year month))))))

(defn nexthackday-date
  "Find the date of the next hackday 'DD-MM-YYYY'"
  []
  (.. (LocalDate/now)
      (with (TemporalAdjusters/lastInMonth DayOfWeek/FRIDAY))
      (toString)))
