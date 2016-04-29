(ns serverless-fun.stream-handler
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.data.json :as json]
            [clojure.string :as s]
            [clojure.java.io :as io]
            [clojure.pprint :refer [pprint]]))

;; Force output to a string
(defn say-hello [data]
  (pprint data)
  (str "Nice to meet you Mr. " (:last-name data) ". May I call you " (:first-name data) "?"))

(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
  ;; Use the double threading macro to push arguments to end instead of second
    (->> (json/read (io/reader is) :key-fn keyword)
        (say-hello)
        ;; Write String to the writer
        (.write w))
    (.flush w)))
