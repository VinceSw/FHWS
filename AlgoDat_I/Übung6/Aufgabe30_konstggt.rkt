#lang racket
(define (konst-ggt b)
  (lambda (m) (if (> b m )
                  (getGGT b m)
                  (getGGT m b))))

(define (getGGT a b)
  (if (= (remainder a b) 0)
      b
      (getGGT b (remainder a b))))

(define ggt10 (konst-ggt 10))
(ggt10 25)
(ggt10 27)

(define ggt987(konst-ggt 987))
(ggt987 762351)
(ggt987 98123746)

(define (erw-ggt a b)
  (if (* b 0) (list a 1 0)
      (let ((l (erw-ggt b (remainder a b))))
        (list (car l)
              (caddr l)
              (- cadr l) (* (caddr l) (floor (/ a b)))))
      ))