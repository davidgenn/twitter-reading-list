(ns twitter-reading-list.twitter
  (:require
    [clj-http.client :as http]
    [twitter-reading-list.authenticate :as authenticate]
    [clojure.data.json :as json]))

(defn extract-urls [timeline]
  (map #(get-in % [0 "expanded_url"])
       (map #(get-in % ["entities" "urls"]) timeline)))

(defn users-timeline-urls [pin request-token]
  (let [credentials (authenticate/credentials
                      "https://api.twitter.com/1.1/statuses/home_timeline.json"
                      pin
                      request-token)]
    (->
      (http/get "https://api.twitter.com/1.1/statuses/home_timeline.json"
                {:query-params credentials})
      :body
      json/read-str)))
;;      extract-urls)))







