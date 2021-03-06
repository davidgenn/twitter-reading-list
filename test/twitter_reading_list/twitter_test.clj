(ns twitter-reading-list.twitter-test
  (:use midje.sweet)
  (:use twitter-reading-list.twitter))

(def test-timeline
  [
   {"id_str" "620679444479344641", 
    "retweeted" false, 
    "is_quote_status" false, 
    "lang" "en", 
    "truncated" false, 
    "place" nil, 
    "in_reply_to_status_id" nil, 
    "user" 
    {"listed_count" 566, 
     "id_str" "10295842", 
     "profile_link_color" "0084B4", 
     "profile_sidebar_border_color" "FFFFFF", 
     "lang" "en", 
     "follow_request_sent" false, 
     "profile_text_color" "000000", 
     "url" "http://t.co/KjRrs9jCn8", 
     "profile_background_tile" false, 
     "contributors_enabled" false, 
     "favourites_count" 2795, 
     "notifications" false, 
     "friends_count" 3692, 
     "profile_image_url_https" "https://pbs.twimg.com/profile_images/447118732385452032/5E6pYRC__normal.png", 
     "profile_background_color" "009999", 
     "id" 10295842, 
     "is_translator" false, 
     "profile_background_image_url_https" "https://pbs.twimg.com/profile_background_images/519546615787302913/yhGBXpiH.png", 
     "protected" false, 
     "utc_offset" -25200, 
     "name" "O'Reilly Velocity", 
     "verified" false, 
     "time_zone" "Pacific Time (US & Canada)", 
     "location" "Beijing, NYC, AMS, Santa Clara", 
     "is_translation_enabled" false, 
     "profile_image_url" "http://pbs.twimg.com/profile_images/447118732385452032/5E6pYRC__normal.png", "default_profile_image" false, "profile_background_image_url" "http://pbs.twimg.com/profile_background_images/519546615787302913/yhGBXpiH.png", "profile_banner_url" "https://pbs.twimg.com/profile_banners/10295842/1434492196", "statuses_count" 7451, "created_at" "Fri Nov 16 05:51:33 +0000 2007", "geo_enabled" true, "followers_count" 12938, "has_extended_profile" false, "profile_sidebar_fill_color" "FFFFFF", "profile_use_background_image" true, "default_profile" false, "screen_name" "velocityconf", "following" true, "description" "Join web performance, DevOps & continuous delivery experts at http://t.co/ixgbwnM1q5", "entities" {"url" {"urls" [{"url" "http://t.co/KjRrs9jCn8", "expanded_url" "http://oreil.ly/velo", "display_url" "oreil.ly/velo", "indices" [0 22]}]}, "description" {"urls" [{"url" "http://t.co/ixgbwnM1q5", "expanded_url" "http://velocityconf.com", "display_url" "velocityconf.com", "indices" [62 84]}]}}}, "favorited" false, "id" 620679444479344641, "in_reply_to_screen_name" nil, "coordinates" nil, "favorite_count" 0, "geo" nil, "text" "What if we continuously deliver our cars? Great post by @weekstweets Chevy &amp; #DevOps https://t.co/yIhEYeeyRP", "in_reply_to_user_id" nil, "in_reply_to_user_id_str" nil, "source" "<a href=\"http://twitter.com\" rel=\"nofollow\">Twitter Web Client</a>", "created_at" "Mon Jul 13 19:41:25 +0000 2015", "in_reply_to_status_id_str" nil, "possibly_sensitive" false, "possibly_sensitive_appealable" false, "contributors" nil, "retweet_count" 0, "entities" {"hashtags" [{"text" "DevOps", "indices" [81 88]}], "symbols" [], "user_mentions" [{"screen_name" "weekstweets", "name" "Derek E. Weeks", "id" 40929930, "id_str" "40929930", "indices" [56 68]}], "urls" [{"url" "https://t.co/yIhEYeeyRP", "expanded_url" "https://medium.com/compliance-at-velocity/chevy-and-devops-what-the-wi-fi-a07946293358", "display_url" "medium.com/compliance-at-…", "indices" [89 112]}]}} {"id_str" "620678047172292610", "retweeted" false, "is_quote_status" false, "lang" "en", "truncated" false, "place" nil, "in_reply_to_status_id" nil, "user" {"listed_count" 1634, "id_str" "1138959692", "profile_link_color" "0084B4", "profile_sidebar_border_color" "FFFFFF", "lang" "en", "follow_request_sent" false, "profile_text_color" "333333", "url" "http://t.co/ZAMxePUASD", "profile_background_tile" false, "contributors_enabled" false, "favourites_count" 896, "notifications" false, "friends_count" 1312, "profile_image_url_https" "https://pbs.twimg.com/profile_images/378800000124779041/fbbb494a7eef5f9278c6967b6072ca3e_normal.png", "profile_background_color" "C0DEED", "id" 1138959692, "is_translator" false, "profile_background_image_url_https" "https://pbs.twimg.com/profile_background_images/433033163481157632/I01VJL_c.png", "protected" false, "utc_offset" -25200, "name" "Docker", "verified" false, "time_zone" "Arizona", "location" "San Francisco, CA", "is_translation_enabled" false, "profile_image_url" "http://pbs.twimg.com/profile_images/378800000124779041/fbbb494a7eef5f9278c6967b6072ca3e_normal.png", "default_profile_image" false, "profile_background_image_url" "http://pbs.twimg.com/profile_background_images/433033163481157632/I01VJL_c.png", "statuses_count" 4440, "created_at" "Fri Feb 01 07:12:46 +0000 2013", "geo_enabled" true, "followers_count" 71819, "has_extended_profile" false, "profile_sidebar_fill_color" "DDEEF6", "profile_use_background_image" true, "default_profile" false, "screen_name" "docker", "following" true, "description" "Open Platform for Distributed Applications", "entities" {"url" {"urls" [{"url" "http://t.co/ZAMxePUASD", "expanded_url" "http://docker.com", "display_url" "docker.com", "indices" [0 22]}]}, "description" {"urls" []}}}, "favorited" false, "id" 620678047172292610, "in_reply_to_screen_name" nil, "coordinates" nil, "favorite_count" 1, "geo" nil, "text" "\"Scalable Groups: Extensibility &amp; Load Balancing Workload w/ @IBMContainers\" by @chrisrosen188: http://t.co/ewZarX5677 #DockerWeekly @Docker", "in_reply_to_user_id" nil, "in_reply_to_user_id_str" nil, "source" "<a href=\"http://www.hootsuite.com\" rel=\"nofollow\">Hootsuite</a>", "created_at" "Mon Jul 13 19:35:52 +0000 2015", "in_reply_to_status_id_str" nil, "possibly_sensitive" false, "possibly_sensitive_appealable" false, "contributors" nil, "retweet_count" 2, "entities" {"hashtags" [{"text" "DockerWeekly", "indices" [123 136]}], "symbols" [], "user_mentions" [{"screen_name" "IBMContainers", "name" "IBM Containers", "id" 3342258287, "id_str" "3342258287", "indices" [65 79]} {"screen_name" "ChrisRosen188", "name" "Chris Rosen", "id" 517685300, "id_str" "517685300", "indices" [84 98]} {"screen_name" "docker", "name" "Docker", "id" 1138959692, "id_str" "1138959692", "indices" [137 144]}], "urls" [{"url" "http://t.co/ewZarX5677", "expanded_url" "http://blog.ibmjstart.net/2015/06/27/scalable-groups-extensibility-and-load-balancing-your-workload-with-ibm-containers/", "display_url" "blog.ibmjstart.net/2015/06/27/sca…", "indices" [100 122]}]}}])

(def tweets 
  [{:tweet "A tweet" :user "A user" :urls ["http://url.one"] :favourites 1 :retweets 7}
   {:tweet "A middle tweet" :user "" :urls [] :favourites 1 :retweets 13}
   {:tweet "A second tweet" :user "A second user" :urls ["http://url.two"] :favourites 21 :retweets 3}])

(def sorted-tweets 
  [{:tweet "A second tweet" :user "A second user" :urls ["http://url.two"] :favourites 21 :retweets 3}
   {:tweet "A middle tweet" :user "" :urls [] :favourites 1 :retweets 13}
   {:tweet "A tweet" :user "A user" :urls ["http://url.one"] :favourites 1 :retweets 7}])

(def filtered-tweets 
  [{:tweet "A tweet" :user "A user" :urls ["http://url.one"] :favourites 1 :retweets 7}
   {:tweet "A second tweet" :user "A second user" :urls ["http://url.two"] :favourites 21 :retweets 3}])

(facts "about Twitter functionality"
  (fact "extract-data extracts data from tweets"
    (extract-data test-timeline) => 
    [{:urls ["https://medium.com/compliance-at-velocity/chevy-and-devops-what-the-wi-fi-a07946293358"]
      :tweet "What if we continuously deliver our cars? Great post by @weekstweets Chevy &amp; #DevOps https://t.co/yIhEYeeyRP"
      :user "O'Reilly Velocity"
      :favourites 0
      :retweets 0}
     {:user "Docker"
      :tweet "\"Scalable Groups: Extensibility &amp; Load Balancing Workload w/ @IBMContainers\" by @chrisrosen188: http://t.co/ewZarX5677 #DockerWeekly @Docker"
      :urls ["http://blog.ibmjstart.net/2015/06/27/scalable-groups-extensibility-and-load-balancing-your-workload-with-ibm-containers/"]
      :favourites 1
      :retweets 2}])

  (fact "sorting-tweets"
    (sort-tweets tweets) => sorted-tweets)

  (fact "filtering-tweets"
    (filter-tweets tweets) => filtered-tweets))


