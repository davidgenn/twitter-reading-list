(defproject twitter-reading-list "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [clj-oauth "1.5.2"]
                 [jarohen/nomad "0.7.1"]
                 [org.clojure/data.json "0.2.6"]
                 [com.draines/postal "1.11.3"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler twitter-reading-list.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [midje "1.7.0"]]
         :plugins [[lein-midje "3.0.0"]]}}
  :main twitter-reading-list.core)
