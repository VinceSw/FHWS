#lang racket
(define (sqr x) (* x x))
(define (squared-max x y z)
  (if (and (> (sqr x) (sqr y)) (> (sqr x) (sqr z))) (sqr x)
      (if (and (> (sqr y) (sqr x)) (> (sqr y) (sqr z))) (sqr y) (sqr z))))