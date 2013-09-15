(defproject storypointestimator/storypointestimator "0.0.1-SNAPSHOT"
  :description "Story Point Estimator for user stories"
  ;:url "http://example.com/FIXME"
  :license {:name "GNU General Public License, version 2"
            :url "https://www.gnu.org/licenses/gpl-2.0.html"}
  :min-lein-version "2.0.0"

  :warn-on-reflection true

  :source-paths ["src/clojure" "src"]
  :java-source-paths ["src/java" "gen"]

  :dependencies [[org.clojure-android/clojure "1.5.1-jb"]
                 [neko/neko "3.0.0-beta6"]]
  :profiles {:dev {:dependencies [[android/tools.nrepl "0.2.0-bigstack"]
                                  [compliment "0.0.2"]]
                   :android {:aot :all-with-unused}}
             :release {:android
                       {;; Specify the path to your private keystore
                        ;; and the the alias of the key you want to
                        ;; sign APKs with. Do it either here or in
                        ;; ~/.lein/profiles.clj
                        ;; :keystore-path "/home/user/.android/private.keystore"
                        ;; :key-alias "mykeyalias"
                        :aot :all}}}

  :android {;; Specify the path to the Android SDK directory either
            ;; here or in your ~/.lein/profiles.clj file.
            ;; :sdk-path "/home/user/path/to/android-sdk/"

            ;; Uncomment this if dexer fails with
            ;; OutOfMemoryException. Set the value according to your
            ;; available RAM.
            ;; :dex-opts ["-JXmx4096M"]

            ;; If previous option didn't work, uncomment this as well.
            ;; :force-dex-optimize true

            :target-version "15"
            :aot-exclude-ns ["clojure.parallel" "clojure.core.reducers"]})
