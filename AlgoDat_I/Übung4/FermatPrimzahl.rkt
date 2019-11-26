#lang racket
(define (primzahl? n)
  (if (or (= n 2) (and (> n 1) (= (fakt n) 1))) #t #f))

(define (fakt n)
  (if (even? n) 2
      (let* ((a (get-corrected-a (ceiling (sqrt n)) n)) ;Aufruf der iterativen Prozedur get-corrected-a um das a zu finden, bei dem b2 eine ganze Zahl ist
             (bsqr (get-b a n)))
        (- a (sqrt bsqr)))))

(define (get-corrected-a a n)
  (let ((b (get-b a n)))
    (if (integer? (sqrt b))
        a
        (get-corrected-a (+ a 1) n))))

(define (get-b a n)
  (- (expt a 2) n))