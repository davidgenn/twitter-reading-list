(ns twitter-reading-list.twitter
  (:require
    [clj-http.client :as http]
    [twitter-reading-list.authenticate :as authenticate]))

(defn users-timeline
  (let [credentials (authenticate/credentials "https://api.twitter.com/1.1/statuses/home_timeline.json")]
    (http/get "https://api.twitter.com/1.1/statuses/home_timeline.json"
              {:query-params credentials}))
  )
