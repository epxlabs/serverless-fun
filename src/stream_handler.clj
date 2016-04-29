(ns stream-handler
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.data.json :as json]
            [clojure.string :as s]
            [clojure.java.io :as io]
            [clojure.pprint :refer [pprint]]))

(defn say-hello [data]
  (pprint data)
  (str "Nice to meet you Mr. " (:first-name data) ". May I call you " (:last-name data)))

(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
    (-> (json/read (io/reader is))
        (say-hello)
        (json/write w))
    (.flush w)))
