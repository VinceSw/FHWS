#lang racket
(define (expandiere sym-liste)
  (expand-iter sym-liste "" (list) 0))

(define (expand-iter l temp newList counter)
  (if (> counter 0)
      (expand-iter l temp (cons temp newList) (- counter 1))
      (if (null? l)
          (reverse newList)
          (if (integer? (car l))
              (expand-iter (cddr l) (car (cdr l)) newList (car l))
              (expand-iter (cdr l) (car l)  newList 1)
              )
          )
      )
  )


; ============================= Beispiele =============================
(expandiere '(7 b a 3 c))
(expandiere '(2 b 2 b c))