#lang racket
(define (loeschen l n)
  (loeschen-iter l n))

(define (loeschen-iter l n)
  (if (> n 0)
      (if (null? l)
          '()
          (loeschen-iter (cdr l) (- n 1)))
      l)
  )

(loeschen '(2 3 4 5 6 7) 3)
(loeschen '(a b c d e f g h i j k l) 5)
(loeschen '(2 3 4 5 6 7 8 9 100 155) 4)
(loeschen '(2) 3)
