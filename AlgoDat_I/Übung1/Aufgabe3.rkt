#lang racket
(define (my-max x y)
  (cond ((> x y) x)
        ((<= x y) y)))
        
