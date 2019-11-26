#lang racket
(define (nat-wurzel x)
  (nat-iter x 0 0 1))

(define (nat-iter n sum counter nextOdd)
  (if (= n sum)
      counter
      (nat-iter n (+ sum nextOdd) (+ counter 1) (+ nextOdd 2))
  )
)