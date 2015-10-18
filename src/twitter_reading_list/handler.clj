(ns twitter-reading-list.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as ring-response]
            [twitter-reading-list.core :as core]
            [ring.adapter.jetty :as jetty]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/auth-url/:email" [email] (ring-response/redirect (:approval-url (core/authorise-app email))))
  (GET "/reading-list/:pin/:email" [pin email] (core/send-reading-list pin email))
  (GET "/session/:email" [email :as request] (core/send-reading-list-2 email request))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (jetty/run-jetty app-routes {:port port})))
