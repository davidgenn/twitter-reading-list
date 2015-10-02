(ns twitter-reading-list.core
  (:require
    [twitter-reading-list.authenticate :as authenticate]
    [twitter-reading-list.twitter :as twitter]
    [twitter-reading-list.email :as email]))

(defn authorise-app []
  (authenticate/approval-url))

(defn send-reading-list [pin email]
  (->
    (twitter/users-tweets pin)
    email/build-email-body
    (email/send-email email)))

