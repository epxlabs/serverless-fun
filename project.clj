(defproject serverless-fun "0.1.0-SNAPSHOT"
  :description "Playing around with AWS Lambda"
  :url "https://github.com/epxlabs/serverless-fun"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.amazonaws/aws-lambda-java-core "1.1.0"]
                 [org.clojure/data.json "0.2.6"]]
  :java-source-paths ["src/java"]
  :aot :all)
