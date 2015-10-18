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
   :urls (extract-urls (get-in input ["entities" "urls"]))
   :favourites (get input "favorite_count")
   :retweets (get input "retweet_count")})

(defn extract-data [timeline]
  (map build-data timeline))

(defn sort-tweets [tweets]
  (sort-by 
   #(* -1 
       (+ (:favourites %) (:retweets %))) 
   tweets))

(defn filter-tweets [tweets]
  (filter 
   #(not 
     (empty? (:urls %)))
   tweets))

(defn users-tweets [verifier]
  (let [credentials (authenticate/credentials
                     "https://api.twitter.com/1.1/statuses/home_timeline.json"
                     verifier)]
    (->
     (http/get "https://api.twitter.com/1.1/statuses/home_timeline.json"
               {:query-params credentials})
     :body
     json/read-str
     extract-data
     filter-tweets
     sort-tweets)))







