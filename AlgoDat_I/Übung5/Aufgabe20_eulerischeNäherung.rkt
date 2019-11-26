#lang racket
(define (euler-n n)
  (euler-iter n 0 0))

(define (euler-iter n counter summe)
  (if (> counter n)
      summe
      (euler-iter n (+ counter 1) (+ summe (/ 1.0 (fakultaet counter 1 1))))))

(define (fakultaet x counter produkt)
  (if (>= counter x)
      (* produkt counter)
      (fakultaet x (+ counter 1) (* produkt counter))))