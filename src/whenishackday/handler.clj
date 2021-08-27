(ns whenishackday.handler
  (:require [whenishackday.time :as time]
            [compojure.core :refer [defroutes context GET ANY POST]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (context "/" []
    (GET "/" [] "When is the hackday?")
    (GET "/count/days" [] (str (time/nexthackday-day-count)))
    (GET "/date" [] (time/nexthackday-date))
    (POST "/holyday" [] (route/not-found "TO BE IMPLEMENTED"))
    (ANY "*" [] (route/not-found "Not Found"))))

(def app
  (wrap-defaults app-routes site-defaults))
