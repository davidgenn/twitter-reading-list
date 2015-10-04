(ns twitter-reading-list.authenticate
  (:require
    [oauth.client :as oauth]
    [nomad :refer [defconfig]]
    [clojure.java.io :as io]))

(defconfig config (slurp (io/as-url "http://kenya2020.org.uk/config.edn")))

;; Create a Consumer to access Twitter.
(def consumer (oauth/make-consumer (:twitter-token (config))
                                   (:twitter-secret (config))
                                   "https://api.twitter.com/oauth/request_token"
                                   "https://api.twitter.com/oauth/access_token"
                                   "https://api.twitter.com/oauth/authorize"
                                   :hmac-sha1))

;; Fetch a request token that a OAuth User may authorize
(defn request-token [] (oauth/request-token consumer))

;; The current request token being used as part of the approval flow - a totally naive implementation atm, but it will do
(def current-request-token (ref {}))

;; Send the User to this URI for authorization, they will be able
;; to choose the level of access to grant the application and will
;; then be redirected to the callback URI provided with the
;; request-token.
(defn approval-url []
  (let [request-token (request-token)
        approval-url (oauth/user-approval-uri consumer
                                              (:oauth_token request-token))]
    (dosync 
      (ref-set current-request-token request-token))
    {:request-token request-token
     :approval-url  approval-url})
  )


;; Assuming the User has approved the request token, trade it for an access token.
;; The access token will then be used when accessing protected resources for the User.
;;
;; If the OAuth Service Provider provides a verifier, it should be included in the
;; request for the access token.  See [Section 6.2.3](http://oauth.net/core/1.0a#rfc.section.6.2.3) of the OAuth specification
;; for more information.
(defn access-token-response [pin request-token] (oauth/access-token consumer
                                                                    request-token
                                                                    pin)) ;; PIN

;; Each request to a protected resource must be signed individually.  The
;; credentials are returned as a map of all OAuth parameters that must be
;; included with the request as either query parameters or in an
;; Authorization HTTP header.
(defn credentials [url pin]
  (println @current-request-token)
  (let [token-response (access-token-response pin @current-request-token)]
    (oauth/credentials consumer
                       (:oauth_token token-response)
                       (:oauth_token_secret token-response)
                       :GET
                       url)))
