(defproject zenathark/nectcorder "0.0.1-SNAPSHOT"
  :description "Kinect recorder depth + video"
  :url "http://github.com/zenathark/nectcorder"
  :license "MIT"
  :plugins [[lein-tools-deps "0.4.5"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :user :project]}
  :profiles {:dev {:lein-tools-deps/config {:resolve-aliases [:test]}}})