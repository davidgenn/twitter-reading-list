(ns twitter-reading-list.twitter
  (:require
    [clj-http.client :as http]
    [twitter-reading-list.authenticate :as authenticate]
    [clojure.data.json :as json]))

(defn extract-urls [urls]
  (map #(get % "expanded_url") urls))

(defn build-data [input] 
  {:tweet (get input "text")
   :user (get-in input ["user" "name"])
   :urls (extract-urls (get-in input ["entities" "urls"]))})

(defn extract-data [timeline]
  (map build-data timeline))

(defn users-timeline-urls [pin request-token]
  (let [credentials (authenticate/credentials
                      "https://api.twitter.com/1.1/statuses/home_timeline.json"
                      pin
                      request-token)]
"hi"
    (->
      (http/get "https://api.twitter.com/1.1/statuses/home_timeline.json"
                {:query-params credentials})
      :body
      json/read-str
     extract-data)
    ))







