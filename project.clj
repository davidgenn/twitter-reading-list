(defproject twitter-reading-list "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-oauth "1.5.2"]
                 [jarohen/nomad "0.7.1"]]
  :main ^:skip-aot twitter-reading-list.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
