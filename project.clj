(defproject starter "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]

                 [org.clojure/tools.cli "0.4.2"]

                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]   
                 [ring/ring-jetty-adapter "1.7.1"]

                 [selmer "1.12.12"]

                 ]

  :repl-options {:init-ns starter.core}

  :plugins [[lein-ring "0.12.5"]]
  :ring {:init starter.core/initialize
         :handler starter.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}
   :provided
   {:dependencies [[org.bouncycastle/bcprov-jdk15on "1.54"]]}}

  :main starter.core
)
