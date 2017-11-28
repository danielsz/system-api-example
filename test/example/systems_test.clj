(ns example.systems-test
  (:require [example.systems :as sut]
            [clojure.test [testing deftest is] :as t]))

(deftest api-and-site
  (is (= 6 (+ 3 3))))
