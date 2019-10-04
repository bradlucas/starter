(ns starter.handler
  (:require [compojure.core :refer [routes GET defroutes]]
            [compojure.route :as route]))


(defn index [req]
  "Hello")

(defroutes main-routes
  (GET "/" [] index))

(def app
  (routes main-routes
          (route/not-found "Not Found")))


