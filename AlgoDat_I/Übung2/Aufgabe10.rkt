#lang racket
(define (f#t a b)
  (or (and (eqv? a #f) (eqv? b #t)) (and (eqv? b #f) (eqv? a #t))))

(define (f2 a b c)
  (or (and (or (eqv? a #t) (eqv? b #t)) (or (eqv? a #t) (eqv? c #f))) (or (eqv? a #f) (and (eqv? b #f) (eqv? c #t)))))

(define (f3 a b c d)
  (and (or (and (eqv? a #f) (eqv? b #f)) (and (eqv? a #t) (eqv? b #t))) (and (eqv? a #f) (eqv? b #t) (eqv? c #f)) (or (eqv? d #f) (eqv? c #f) (eqv? b #f) (eqv? a #f))))