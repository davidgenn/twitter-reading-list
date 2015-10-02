(ns twitter-reading-list.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [twitter-reading-list.core :as core]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/auth-url" [] (core/authorise-app))
  (GET "/reading-list/:pin/:email" [pin email] (core/send-reading-list pin email))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
