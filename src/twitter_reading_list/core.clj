(ns twitter-reading-list.core
  (:require
    [twitter-reading-list.authenticate :as authenticate]
    [twitter-reading-list.twitter :as twitter]
    [twitter-reading-list.email :as email]))

(defn authorise-app [email]
  (authenticate/approval-url email))

(defn send-reading-list-2 [email oauth_token oauth_verifier request]
  ;; (println email)
  (println "oauth_token " oauth_token)
  (println "oauth_verifier " oauth_verifier)
  (println "email " email)
  (println "request: " request)
  (println "oauth token: " (get-in request [:params :oauth_token]))
  (println "query string: " (:query-string request))
  (println "params: " (:params request))
  ;; (->
  ;;  (twitter/users-tweets oauth_token oauth_verifier)
  ;;  email/build-email-body
  ;;  (email/send-email email)
  ;; )
  "Email sent!")

(defn send-reading-list [pin email]
  (->
   (twitter/users-tweets pin)
   email/build-email-body
   (email/send-email email))
  "Email sent!")

