#lang racket
(define (caesar_encrypt_list data key)
  (caesar-iter data key newL counter))

(define (caesar-iter d k newL c)
  (if (null? d)
      (if (= c 0)
          (caesar-iter d k newL 3)
          
      