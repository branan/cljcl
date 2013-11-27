(ns cljcl.core-test
  (:require [clojure.test :refer :all]
            [cljcl.core :refer :all]))

(deftest test-form-type
  (testing "Addition is infix"
    (is (='infix (form-type '(+ 1 2)))))
  (testing "defn is a special form"
    (is (= 'let (form-type '(let [a b])))))
  (testing "types are variable declarations"
    (is (= 'variable (form-type '(float const pointer)))))
  (testing "anything else is a function"
    (is (= 'function (form-type '(pow 2 3))))))
