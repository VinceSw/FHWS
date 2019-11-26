#lang racket
(define (paar-operation op)
  (lambda (x) (if (op (car x) (cdr x))
                    #t
                    #f)))

(define paar=? (paar-operation =))
(paar=? (cons 2 3))
(paar=? (cons 3 3))

(define paar<? (paar-operation <))
(paar<? (cons 2 3))
(paar<? (cons 3 3)) 