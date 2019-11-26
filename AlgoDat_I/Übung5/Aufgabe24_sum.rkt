#lang racket
(define (n x) (+ x 1))

(define (sum x y)
  (if (= y 0) 0 (+ x (- y 1))))