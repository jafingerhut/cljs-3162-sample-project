(ns cljs-3162-sample-project.sample-test
  (:require [clojure.test :refer :all]
            [cljs-3162-sample-project.sample :refer :all]))

(deftest a-test
  (is (= 5 (throw (Exception. "my custom exception")))))

(deftest b-test
  (is (= 5 (+ 2 3))))
