(ns twitter-reading-list.email
  (:require [postal.core :as postal]))

;; requires permission for 'less secure' apps to be turned on
(defn send-email []
  (postal.send-message {:host "smtp.gmail.com"
                            :user "davidgenn"
                            :pass password
                            :tls true}
                           {:from "davidgenn@gmail.com"
                            :to "davidgenn@gmail.com"
                            :subject "Hi!"
                            :body "Test."})
)
