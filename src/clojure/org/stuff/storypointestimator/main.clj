(ns org.stuff.storypointestimator.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.notify :only [toast]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]
        [neko.application :only [defapplication]]))

(def ^:const MAX-POINT-VALUE 40)

(declare ^android.widget.TextView points-text)

(defn next-fibonacci [fibs]
  (+ (nth fibs (- (count fibs) 1))
     (nth fibs (- (count fibs) 2))))

(defn fibonaccies-smaller-than-generated [n generated]
  (if (> (next-fibonacci generated) n)
    generated
    (fibonaccies-smaller-than-generated n (concat generated (list (next-fibonacci generated))))))

(defn fibonaccies-smaller-than [n]
  (fibonaccies-smaller-than-generated n [1 1]))

(defn get-story-point-estimate []
  (rand-nth (fibonaccies-smaller-than MAX-POINT-VALUE)))

(defn notify-estimate [_]
  (.setText points-text (str (get-story-point-estimate))))

(defactivity org.stuff.storypointestimator.MainActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! a
      (make-ui [:linear-layout {:orientation :vertical
                                :layout-width :fill
                                :layout-height :fill}
                [:text-view {:def `points-text
                             :text "0"
                             :text-size [100 :dp]}]
                [:linear-layout {:layout-weight 2}]
                [:button {:text "Estimate!"
                          :on-click notify-estimate}]])))))
