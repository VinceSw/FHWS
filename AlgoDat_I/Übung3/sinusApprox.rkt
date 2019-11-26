#lang racket
(define (sinus-approx x)
  (cond ((<= x 0.1) x)
        (sinus-approx (- (* 3.0 (sinus-approx (/ x 3))) (* 4 (expt (sinus-approx (/ x 3)) 3))))))