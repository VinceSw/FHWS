#lang racket
(define (drehe liste)
  (drehen-iter liste (list)))

(define (drehen-iter l newL)
  (if (null? l)
      newL
      (drehen-iter  (cdr l) (cons (car l) newL))
      )
  )


(drehe (list 1 2 3))
(drehe (list 1 2 (list 3)))
(drehe (list 1 (list 5 6) 2 (list 3 4)))