#lang racket
(define (typ-or typ1 typ2)
  (lambda (a) (checkType typ1 typ2 a)))

(define (checkType typ1 typ2 a)
  (if (or (typ1 a) (typ2 a))
          #t
          #f))

;================================ Beispiele ================================
  (define paar-oder-liste? (typ-or pair? list?))
  (define integer-oder-boolean? (typ-or integer? boolean?))
  (integer-oder-boolean? (paar-oder-liste? (cons 1 2)))