(ns twitter-reading-list.email-test
  (:use midje.sweet)
  (:use twitter-reading-list.email))

(def tweets 
  [{:tweet "A tweet" :user "A user" :urls ["http://url.one"]}
   {:tweet "A second tweet" :user "A second user" :urls ["http://url.two"]}])

(facts "about Email functionality"
  (fact "Building an email body from multiple tweets"
    (build-email-body tweets) =>
"Hi David!

Here's your reading list:

A tweet - by A user - http://url.one

A second tweet - by A second user - http://url.two

Happy reading!"))
