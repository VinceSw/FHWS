#lang racket
(define (q n)
  (if (= n 1)
      1
      (if (= n 2)
          1
          (+ (q (- n (q (- n 1)))) (q (- n (q (- n 2)))))))) 