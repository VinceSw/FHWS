#lang racket
(define (kubiksumme n)
  (cond ((integer? n) (expt (quersumme n) 3))))

(define (quersumme x)
  (if (= x 0)
      0
      (+ (remainder x 10) (quersumme (/ (- x (remainder x 10)) 10)))))
  