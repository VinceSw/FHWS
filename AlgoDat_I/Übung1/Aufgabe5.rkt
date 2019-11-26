#lang racket
(define (groesserp? x y z)
  (if (> (+ x y) z) #t #f))
       