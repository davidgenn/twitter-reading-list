(ns twitter-reading-list.core
  (:require
    [twitter-reading-list.authenticate :as authenticate]
    [twitter-reading-list.twitter :as twitter]
    [twitter-reading-list.email :as email]
    [twitter-reading-list.handler :as handler]))

(defn authorise-app []
  (authenticate/approval-url))

(defn send-reading-list [pin email]
  (->
    (twitter/users-tweets pin)
    email/build-email-body
    (email/send-email email))
  "Email sent!
")

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (jetty/run-jetty handler/app-routes {:port port})))

