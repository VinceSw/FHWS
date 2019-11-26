#lang racket
(define (caesar_encrypt_list data key)
  (caesar-iter data key key (list)))

(define (caesar-iter data key keyTemp newList)
  (if (null? data)
      (cond ((not (null? newList))
          (reverse-list newList (list))
          ))
      (if (null? keyTemp)
          (caesar-iter data key key newList)
          (caesar-iter (cdr data) key (cdr keyTemp) (cons (if (>= (+ (car data) (car keyTemp)) 10)
                                                              (- (+ (car data) (car keyTemp)) 10)
                                                              (+ (car data) (car keyTemp))) newList))
          )
      )
  )

(define (reverse-list l reverseL)
  (if (null? l)
      reverseL
      (reverse-list (cdr l) (cons (car l) reverseL))
      )
  )

; ============================= Beispiele =============================

(caesar_encrypt_list (list 1 2 3 4 5 6) (list 1 3 3 7))
(caesar_encrypt_list (list 0 3 0 1 1 9 8 9) (list 2 0 1 4))
(caesar_encrypt_list (list 9 0 0 7 1 1 9 2) (list 1 9 9 9))
