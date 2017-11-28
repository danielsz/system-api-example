(ns example.handler
  (:require
   [compojure.core :refer [routes GET POST context]]
   [ring.util.response :refer [response content-type]]
   [example.html :as html]))

(defn site-routes [_]
  (routes 
   (GET "/" [] (html/index))
   (POST "/message" [] (do))))

(defn api-routes [_]
  (routes
   (context "/api" []
       (GET "/" [] (-> (response "Example.")
                       (content-type "text/plain")))
       (POST "/message" {:keys [params] :as req} (-> (response (str params))
                                                     (content-type "text/plain"))))))

