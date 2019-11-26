#lang racket
(define (loesche liste prädikat)
  (loesche-iter liste prädikat))

(define (loesche-iter l f)
  (if (f (car l))
      (loesche-iter (cdr l) f)
      l))

(loesche (list 4 6 8 3 2 4 5) even?)

(loesche (list 3 5 7 9 9 2 4 5) even?)

(loesche (list 3 5 7 9 9 2 4 5) odd?)