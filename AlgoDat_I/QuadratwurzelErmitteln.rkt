#lang racket
;something's not working right. Squareroot of 2 is 1.4142156862745097 but should be 1.41421356237
(define (wurzel x)
  (wurzel-iter 1.0 x))

(define (wurzel-iter schaetzwert x)
  (if (gut-genug? schaetzwert x)
      schaetzwert
      (wurzel-iter (verbessern schaetzwert x) x)))

(define (gut-genug? schaetzwert x)
  (<= (abs (- (quadrat schaetzwert) x)) 0.000001))

(define (quadrat x)
  (* x x))

(define (verbessern schaetzwert x)
  (mittelwert schaetzwert (/ x schaetzwert)))

(define (mittelwert x y)
  (/ (+ x y) 2))