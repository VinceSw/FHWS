#lang racket
(define (testen n)
  (testen-iter n 0 0))

(define (testen-iter n even odd)
  (if (> n 0)
      (if (remainder n 10)
          (testen-iter (remainder n 10) 