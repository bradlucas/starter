(ns starter.template
  (:require [selmer.parser :as parser]))


(defn render-file [req template map]
  (parser/render-file template map))

