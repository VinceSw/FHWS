#lang racket
(define (aufsteigendes-produkt? a b c d)
  (and (> d c b a) (= (* a b c) d))
)