#lang racket
(define (count-perm x)
  (perm-iter 1 1 x))

(define (perm-iter product counter n)
  (if (>= counter n)
      (* product counter)
      (perm-iter (* counter product) (+ counter 1) n)))