(ns starter.handler
  (:require [compojure.core :refer [routes GET defroutes]]
            [compojure.route :as route]
            [starter.routes.auth :as auth]
            [starter.routes.account :as account]
            [starter.routes.static :as static]
            [starter.middleware :as middleware]))


(def app
  (middleware/wrap-base (routes static/routes
                                auth/routes
                                (middleware/wrap-restricted account/routes)
                                (route/not-found "Not Found"))))


