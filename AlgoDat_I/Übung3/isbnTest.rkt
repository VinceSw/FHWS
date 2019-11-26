#lang racket
(define (isbn-test x)
  (cond ((= (remainder (isbn-sum 0 0 x) 11) 10) "X")
        (else (remainder (isbn-sum 0 0 x) 11))))


(define (isbn-sum product counter n)
  (if (> counter 9)
      product
      (isbn-sum (+ product (* counter (remainder (quotient n (expt 10 (- 9 counter))) (expt 10 1)))) (+ counter 1) n)))