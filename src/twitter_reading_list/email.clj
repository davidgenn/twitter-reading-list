(ns twitter-reading-list.email
  (:require 
    [postal.core :as postal]
    [nomad :refer [defconfig]]
    [clojure.java.io :as io]))

(defconfig config (io/resource "config.edn"))



;; requires permission for 'less secure' apps to be turned on
(defn send-email []
  (postal/send-message {:host "smtp.gmail.com"
                            :user "davidgenn"
                            :pass (:gmail-password (config))
                            :tls true}
                           {:from "davidgenn@gmail.com"
                            :to "davidgenn@gmail.com"
                            :subject "Hi!"
                            :body "Test."})
)
