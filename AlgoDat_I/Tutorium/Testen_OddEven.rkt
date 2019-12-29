#lang racket
(define (testen zahl)
  (test-iter zahl 0 0 0))

(define (test-iter zahl zahlTemp countEven countOdd)
  (if (> (- zahl zahlTemp) 0)
      (if (even? (remainder zahl 10))
          (test-iter (quotient zahl 10) (* (remainder zahl 10) (expt 10 (+ countEven countOdd))) (+ countEven 1) countOdd)
          (test-iter (quotient zahl 10) (* (quotient zahl 10) (expt 10 (+ countEven countOdd))) countEven (+ countOdd 1))
          )
      (if (= countEven countOdd)
          #t
          #f)
      )
  )

(testen 123)
(testen 1234)                     