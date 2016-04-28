(ns hello
  (:gen-class
   :methods [^:static [handler [String] String]]))

(defn -handler
  "Lambda main"
  [s]
  (str  "Hello " s "!"))
