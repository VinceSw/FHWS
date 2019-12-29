#lang racket
(define (schachteln l k)
  (schachtel-iter l k))

(define (schachtel-iter l k)
  (if (null? l)
      k
      (cons (car l) (schachtel-iter (cdr l) k))
      )
  )

(schachteln '(1 2 3 4 5) '(6 7 8 9))
(schachteln '(a b c d e f) '(g h i j k l m n o))
