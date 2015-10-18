(ns twitter-reading-list.core
  (:require
   [twitter-reading-list.authenticate :as authenticate]
   [twitter-reading-list.twitter :as twitter]
   [twitter-reading-list.email :as email]
   [clojure.string :as str]))

(defn authorise-app [email]
  (authenticate/approval-url email))

(defn send-reading-list-2 [email request]
  (let [query-params (str/split (:query-string request) #"&")
        oauth-verifier-map (str/split (get query-params 1) #"=")
        oauth-verifier (get oauth-verifier-map 1)]
    (->
     (twitter/users-tweets oauth-verifier)
     email/build-email-body
     (email/send-email email)))
  "Email sent!")

(defn send-reading-list [pin email]
  (->
   (twitter/users-tweets pin)
   email/build-email-body
   (email/send-email email))
  "Email sent!")

