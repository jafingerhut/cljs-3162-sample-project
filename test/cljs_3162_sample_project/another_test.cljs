(ns cljs-3162-sample-project.another-test
  (:require [clojure.test :refer [deftest is]]
            [cljs-3162-sample-project.sample :as s]))

(deftest a-test
  (is (= 5 (throw (js/Error. "my custom exception")))))

(deftest b-test
  (is (= 5 (+ 2 3))))
