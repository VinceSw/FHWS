#lang racket
(define (caesar_encrypt n k)
  (encrypt n k 0))

(define (encrypt n k counter)
  (if (= n 0)
      0
      (+ (if (>= (+ (remainder n 10) k) 10)
             (* (- (+ (remainder n 10) k) 10) (expt 10 counter))
             (* (+ (remainder n 10) k) (expt 10 counter)))
         (encrypt (/ (- n (remainder n 10)) 10) k (+ counter 1)))))