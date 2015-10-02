(ns twitter-reading-list.email
  (:require 
    [postal.core :as postal]
    [nomad :refer [defconfig]]
    [clojure.java.io :as io]))

(defconfig config (io/resource "config.edn"))

(def welcome-text
"Hi David!

Here's your reading list:

")

(def end-text 
"Happy reading!")

(defn parse-tweet [input tweet]
  (str 
  input 
  (:tweet tweet) 
  " - by " 
  (:user tweet) 
  " - " 
  (get (:urls tweet) 0)
  "\n\n"))

(defn tweet-body [tweets]
  (reduce parse-tweet "" tweets))

(defn build-email-body [tweets]
  (str welcome-text (tweet-body tweets) end-text))

;; requires permission for 'less secure' apps to be turned on
(defn send-email [body email]
  (postal/send-message {:host "smtp.gmail.com"
                            :user "davidgenn"
                            :pass (:gmail-password (config))
                            :tls true}
                           {:from "davidgenn@gmail.com"
                            :to email
                            :subject "Twitter reading list"
                            :body body})
)
