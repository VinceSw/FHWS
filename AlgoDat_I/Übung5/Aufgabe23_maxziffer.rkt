#lang racket
(define (maxziffer n)
  (max-iter n 0 0))

(define (max-iter n x y)
  (if (< n 1)
      y
      (max-iter (floor (/ n 10)) (remainder n 10) (if (> x y) x y))))