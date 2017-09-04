(defproject drools "0.1.0-SNAPSHOT"
  :description "drools and clojure project"
  :url "https://github.com/incjung/drools-clojure.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.drools/drools-core "6.5.0.Final"]
                 [org.drools/drools-compiler "6.5.0.Final"]]
  :aot :all
  :main drools.rules.Drooltest)
