(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll)))))

(defn singleton? [coll]
  (and (not (empty? coll))
       (empty? (rest coll))))

(defn my-last [coll]
  (if (empty? coll)
    nil
    (if (singleton? coll)
      (first coll)
      (my-last (rest coll)))))

(defn max-element [a-seq]
  (if (empty? a-seq)
    nil
    (if (singleton? a-seq)
      (first a-seq)
      (max (first a-seq) (max-element (rest a-seq))))))

(defn seq-max [seq-1 seq-2]
  (if (> (count seq-1) (count seq-2))
    seq-1
    seq-2))

(defn longest-sequence [a-seq]
  (if (empty? a-seq)
    nil
    (if (singleton? a-seq)
      (first a-seq)
      (seq-max (first a-seq) (longest-sequence (rest a-seq))))))

(defn my-filter [pred? a-seq]
  (let [element (first a-seq)]
    (if (empty? a-seq)
      a-seq
      (if (pred? element)
        (cons element (my-filter pred? (rest a-seq)))
        (my-filter pred? (rest a-seq))))))

(defn sequence-contains? [elem a-seq]
  (cond
    (empty? a-seq) false
    (= elem (first a-seq)) true
    :else
    (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (cond
    (empty? a-seq)
    a-seq
    (pred? (first a-seq))
    (cons (first a-seq) (my-take-while pred? (rest a-seq)))
    :else
    '()))

(my-take-while odd? [1 2 3 4])                              ;=> (1)
(my-take-while odd? [1 3 4 5])                              ;=> (1 3)
(my-take-while even? [1 3 4 5])                             ;=> ()
(my-take-while odd? [])                                     ;=> ()



(defn my-drop-while [pred? a-seq]
  (cond
    (empty? a-seq)
    a-seq
    (pred? (first a-seq))
    (my-drop-while pred? (rest a-seq))
    :else
    a-seq))



(my-drop-while odd? [1 2 3 4])                              ;=> (2 3 4)
(my-drop-while odd? [1 3 4 5])                              ;=> (4 5)
(my-drop-while even? [1 3 4 5])                             ;=> (1 3 4 5)
(my-drop-while odd? [])                                     ;=> ()

(defn seq= [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq)) true
    (= (first a-seq) (first b-seq)) (seq= (rest a-seq) (rest b-seq))
    :else false))

(seq= [1 2 4] '(1 2 4))   ;true
(seq= [] [])              ;true
(seq= [1 2 nil] [1 2])    ;false
(seq= [1 4 2] [1 2 4])    ;false
(seq= [1 2 3] [1 2 3 4])  ;false
(seq= [1 3 5] [])         ;false

(defn my-map [f seq-1 seq-2]
  (let [a (first seq-1)
        b (first seq-2)]
    (cond
      (or (empty? seq-1) (empty? seq-2)) '()
      (and (not (nil? a)) (not (nil? b)))
      (cons (f a b) (my-map f (rest seq-1) (rest seq-2))))))

(my-map + [1 2 3] [4 4 4])                                  ;=> (5 6 7)
(my-map + [1 2 3 4] [0 0 0])                                ;=> (1 2 3)
(my-map + [1 2 3] [])                                       ;=> ()

(defn power [n k]
  (if (= k 0)
    1
    (* n (power n (dec k)))))


(power 2 2)  ;=> 4
(power 5 3)  ;=> 125
(power 7 0)  ;=> 1
(power 0 10) ;=> 0

(defn fib [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fib (- n 1)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (< how-many-times 1)
    '()
    (cons what-to-repeat
          (my-repeat (dec how-many-times)
                     what-to-repeat))))

(defn my-range [up-to]
  (let [index up-to]
    (if (< index 1)
      '()
      (cons (dec index) (my-range (dec index))))))


(defn tails [a-seq]
  (if (empty? a-seq)
    (cons '() a-seq)
    (cons a-seq (tails (rest a-seq)))))

(tails [1 2 3 4]) ;=> ((1 2 3 4) (2 3 4) (3 4) (4) ())

(defn inits [a-seq]
  (if (empty? a-seq)
    (cons '() a-seq)
    (cons a-seq (inits (reverse (rest (reverse a-seq)))))))

(inits [1 2 3 4]) ;=> (() (1) (1 2) (1 2 3) (1 2 3 4))

(defn rotations [a-seq]
  (if (empty? a-seq)
    a-seq
    (cons (concat (rotations (rest a-seq))
                  (rotations ())))))



(rotations [1 2 3])   ;=> ((1 2 3) (2 3 1) (3 1 2))
(rotations [])        ;=> (())
(rotations [:a :b])   ;=> ((:a :b) (:b :a))
; The order of rotations does not matter.
(rotations [:a :b])   ;=> ((:b :a) (:a :b))
(rotations [1 5 9 2]) ;=> ((1 5 9 2) (2 1 5 9) (9 2 1 5) (5 9 2 1))
(count (rotations [6 5 8 9 2])) ;=> 5

(defn my-frequencies-helper [freqs a-seq]
  [:-])

(defn my-frequencies [a-seq]
  [:-])

(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

