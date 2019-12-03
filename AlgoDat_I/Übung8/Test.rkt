#lang racket
(define (liste-teilen eingabe)
  (listet eingabe (list) 0))

(define (listet l r counter)
  