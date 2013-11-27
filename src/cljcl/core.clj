(ns cljcl.core)

(def infix-forms
  #{'+
    '-
    '*
    '/
    '==
    '!=
    '>=
    '<=
    '<
    '>})

(def special-forms
  #{'assoc
    'defn
    'get
    'let})

(def variable-forms
  #{'float
    'int})

(defn form-type [form]
  (cond
   (contains? special-forms (first form)) (first form)
   (contains? infix-forms (first form)) 'infix
   (contains? variable-forms (first form)) 'variable
   :default 'function))
