#lang racket
(define (zahl-umdrehen x)
  (switch-iter x 0))

(define (switch-iter n reverseNum)
  (if (= n 0)
      reverseNum
      (switch-iter (quotient n 10) (+ (* reverseNum 10) (remainder n 10)))
  )
)
