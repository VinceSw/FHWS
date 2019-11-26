#lang racket
(define (gleiche-ziffern zahl)
  (if (and (integer? zahl) (< zahl 10))
      zahl
      (gziffer-iter (+ zahl 1) (get-firstDigit zahl))
      )
  )

(define (gziffer-iter n firstDigit)
  (if (> firstDigit 0)
      (if (digits-equal? firstDigit n)
          n
          (gziffer-iter (+ n 1) firstDigit)
          )
      0
      )
  )

(define (get-firstDigit x)
  (if (> x 0) (floor (/ x (expt 10 (floor (log x 10))))) 0))

(define (digits-equal? firstDigit n)
  (if (and (= firstDigit (get-firstDigit n)) (= (remainder n 10) firstDigit))
      #t
      #f))