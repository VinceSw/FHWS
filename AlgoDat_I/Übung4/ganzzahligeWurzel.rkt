#lang racket
(define (ganzzahlige-wurzel? n)
  (if (integer? (sqrt n)) #t #f))