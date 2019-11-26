#lang racket
(define (sum x y)
  (if (= y 0) x (+ x y)))

(define (mul x y)
  (if (= y 0)
      0
      (sum x (mul x (- y 1)))
      )
  )