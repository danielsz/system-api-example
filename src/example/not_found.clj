(ns example.not-found
  (:require [compojure.response :as compojure]
            [ring.util.response :as response]
            [clojure.tools.logging :as log]))


(defn log [request]
  (log/error (:server-name request) (:request-method request) (:uri request)))

(defn wrap-not-found
  [handler error-response]
  (fn [request]
    (or (handler request)
        (log request)
        (-> (compojure/render error-response request)
            (response/content-type "text/html")
            (response/status 404)))))


