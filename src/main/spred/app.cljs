(ns main.spred.app
  (:require
   [helix.core :refer [defnc $]]
   [applied-science.js-interop :as j]
   [helix.experimental.refresh :as refresh]
   ["react-native" :as rn]))

;; must use defonce and must refresh full app so metro can fill these in
;; at live-reload time `require` does not exist and will cause errors
;; must use path relative to :output-dir
#_(defonce splash-img (js/require "../assets/shadow-cljs.png"))

(defnc TabA [_]
  ($ rn/View {:style (j/lit {:flex 1, :alignItems "center", :justifyContent "center"
                             :height "50%" :width "50%"
                             :overflow "scroll"})}
     ($ rn/ScrollView {:style (j/lit {:flex 1})}
      ($ rn/Text {:style (j/lit {:fontSize 136})}
        "Tab A and grils and coconut"))))

(defn ^:dev/after-load after-load []
  (refresh/refresh!))

(defn init []
  (rn/AppRegistry.registerComponent "ProjectName" (fn [] TabA))
  (refresh/inject-hook!))


