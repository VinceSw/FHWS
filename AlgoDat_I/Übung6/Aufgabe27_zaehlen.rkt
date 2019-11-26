#lang racket
(define (zaehlen start ende n)
  (if (and (and (integer? start) (integer? ende)) (> n 0))
      (if (< start ende)
          (zaehlen-pos start ende n 1)
          (zaehlen-neg start ende n 1))
      0))

(define (zaehlen-pos start ende n counter)
  (if (< start ende)
      (if (and (= (remainder start 7) 0) (= (remainder start 3) 0))
          (if (= n counter)
              start
              (zaehlen-pos (+ start 1) ende n (+ counter 1)))
          (zaehlen-pos (+ start 1) ende n counter))
      0))

(define (zaehlen-neg start ende n counter)
  (if (> start ende)
       (if (and (= (remainder start 7) 0) (= (remainder start 3) 0))
          (if (= n counter)
              start
              (zaehlen-neg (- start 1) ende n (+ counter 1)))
          (zaehlen-neg (- start 1) ende n counter))
       0))
