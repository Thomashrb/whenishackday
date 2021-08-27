(defproject whenishackday "0.1.0"
  :description "A super simple api for checking when hackday is"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler whenishackday.handler/app
         :port 8000}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})
