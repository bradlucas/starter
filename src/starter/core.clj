(ns starter.core
  (:require [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.tools.cli :refer [parse-opts]]
            [mount.core :as mount]
            [starter.config :as config]
            [starter.handler :as handler]
            [ring.adapter.jetty :as jetty])
  (:gen-class))


(def cli-options
  [["-w" "--web" "Start web app"]
   ["-h" "--help" "Show help usage"]])

(defn usage [summary]
  (->> ["usage: starter.jar [options]"
        "options:"
        summary
        ""
        "Examples:"
        "java -jar starter.jar -w           ;; start web app"
        ""
        ]
       (str/join \newline)))

(defn initialize []
  (config/load-config)
  (mount/start))

(defn -main [& args]
  (initialize)
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
      (cond
        (:help options) (println (usage summary))
        :else (jetty/run-jetty handler/app {:port (config/port)}))))
