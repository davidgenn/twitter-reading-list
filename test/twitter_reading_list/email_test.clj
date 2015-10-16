(ns twitter-reading-list.email-test
  (:use midje.sweet)
  (:use twitter-reading-list.email))

(def tweets 
  [{:tweet "A tweet" :user "A user" :urls ["http://url.one"] :favourites 1 :retweets 2}
   {:tweet "A second tweet" :user "A second user" :urls ["http://url.two"] :favourites 2 :retweets 3}])

(facts "about Email functionality"
  (fact "Building an email body from multiple tweets"
    (build-email-body tweets) =>
"Hi David!

Here's your reading list:

A tweet - by A user - http://url.one Favourites: 1 Retweets: 2

A second tweet - by A second user - http://url.two Favourites: 2 Retweets: 3

Happy reading!"))
