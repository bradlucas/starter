(ns starter.handler
  (:require [compojure.core :refer [routes GET defroutes]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [starter.template :as template]))


(defn index [req]
  (template/render-file req "templates/index.html" {}))

(defroutes main-routes
  (GET "/" [] index))

(defn wrap-base [handler]
  (-> handler
      (wrap-defaults site-defaults)))

(def app
  (wrap-base (routes main-routes
                     (route/not-found "Not Found"))))


