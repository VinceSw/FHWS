#lang racket
(define PI 3.1415926535897932384626433832795)

(define (zylinder-kegel radius-zylinder hoehe-zylinder radius-kegel hoehe-kegel)
  (/ (calc-zylinder radius-zylinder hoehe-zylinder)
   (calc-kegel radius-kegel hoehe-kegel)))

(define (calc-zylinder r h)
  (* (* (expt r 2) h) PI))

(define (calc-kegel r h)
  (* (* (* (/ 1 3) PI) (expt r 2)) h))
