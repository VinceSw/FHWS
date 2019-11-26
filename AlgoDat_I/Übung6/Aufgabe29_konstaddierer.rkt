#lang racket

(define (konst-addierer n)
  (lambda (a) (+ a n)))

(define plus10 (konst-addierer 10))
(plus10 98)

(define plus1 (konst-addierer 1))
(plus1 98)

(define plusNeg5 (konst-addierer -5))
(plusNeg5 98)