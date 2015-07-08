(ns twitter-reading-list.authenticate
  (:require
    [oauth.client :as oauth]
    [nomad :refer [defconfig]]
    [clojure.java.io :as io]))

(defconfig config (io/resource "resources/config.edn"))

;; Create a Consumer to access Twitter.
(def consumer (oauth/make-consumer (:twitter-token (config))
                                   (:twitter-secret (config))
                                   "https://api.twitter.com/oauth/request_token"
                                   "https://api.twitter.com/oauth/access_token"
                                   "https://api.twitter.com/oauth/authorize"
                                   :hmac-sha1))

;; Fetch a request token that a OAuth User may authorize
(def request-token (oauth/request-token consumer))

;; Send the User to this URI for authorization, they will be able
;; to choose the level of access to grant the application and will
;; then be redirected to the callback URI provided with the
;; request-token.
(oauth/user-approval-uri consumer
                         (:oauth_token request-token))

;; Assuming the User has approved the request token, trade it for an access token.
;; The access token will then be used when accessing protected resources for the User.
;;
;; If the OAuth Service Provider provides a verifier, it should be included in the
;; request for the access token.  See [Section 6.2.3](http://oauth.net/core/1.0a#rfc.section.6.2.3) of the OAuth specification
;; for more information.
(def access-token-response (oauth/access-token consumer
                                               request-token
                                               "7276539"))  ;; PIN

;; Each request to a protected resource must be signed individually.  The
;; credentials are returned as a map of all OAuth parameters that must be
;; included with the request as either query parameters or in an
;; Authorization HTTP header.
(defn credentials [url] (oauth/credentials consumer
                                    (:oauth_token access-token-response)
                                    (:oauth_token_secret access-token-response)
                                    :GET
                                    url
                                    ))
