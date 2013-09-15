(ns org.stuff.storypointestimator.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.notify :only [toast]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]
        [neko.application :only [defapplication]]))

(def ^:const MAX-POINT-VALUE 40)

(defn next-fibonacci [l]
  (+ (nth l (- (count l) 1))
     (nth l (- (count l) 2))))

(defn fibonaccies-smaller-than-generated [n generated]
  (if (> (next-fibonacci generated) n)
    generated
    (fibonaccies-smaller-than-generated n (concat generated (list (next-fibonacci generated))))))

(defn fibonaccies-smaller-than [n]
  (fibonaccies-smaller-than-generated n [1 1]))

(defn get-story-point-estimate []
  (rand-nth (fibonaccies-smaller-than MAX-POINT-VALUE)))

(defn notify-estimate [_]
  (toast (str (get-story-point-estimate)) :long))

(defactivity org.stuff.storypointestimator.MainActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! a
      (make-ui [:linear-layout {}
                [:button {:text "Estimate"
                          :on-click notify-estimate}]])))))
