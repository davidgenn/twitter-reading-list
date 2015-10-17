(ns twitter-reading-list.core
  (:require
    [twitter-reading-list.authenticate :as authenticate]
    [twitter-reading-list.twitter :as twitter]
    [twitter-reading-list.email :as email]))

(defn authorise-app [email]
  (authenticate/approval-url email))

(defn send-reading-list-2 [email oauth_token oauth_verifier]
  (println email)
  (println oauth_token)
  (println oauth_verifier)
  (->
   (twitter/users-tweets oauth_token oauth_verifier)
   email/build-email-body
   (email/send-email email))
  "Email sent!")

(defn send-reading-list [pin email]
  (->
   (twitter/users-tweets pin)
   email/build-email-body
   (email/send-email email))
  "Email sent!")

