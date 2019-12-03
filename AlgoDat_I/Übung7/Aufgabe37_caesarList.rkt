#lang racket
;Iterativ
(define (caesar_encrypt_list_i data key)
  (caesar-iter data key key (list)))

(define (caesar-iter data key keyTemp newList)
  (if (null? data)
      (cond ((not (null? newList))
          (reverse-list newList (list))
          ))
      (if (null? keyTemp)
          (caesar-iter data key key newList)
          (caesar-iter (cdr data) key (cdr keyTemp) (cons (remainder (+ (car data) (car keyTemp)) 10) newList))
          )
      )
  )

(define (reverse-list l reverseL)
  (if (null? l)
      reverseL
      (reverse-list (cdr l) (cons (car l) reverseL))
      )
  )


;Rekursiv
(define nil (list))

(define (caesar_encrypt_list data key)
  (define (iter key2 data2)
    (if  (null? data2)
             nil
             (if (null?  key2)
                 (iter key data2)
                 (cons (remainder (+ (car data2) (car key2)) 10) (iter (cdr key2) (cdr data2)))
             )
        )
    )
  (iter key data)
  )
; ============================= Beispiele =============================

(caesar_encrypt_list (list 1 2 3 4 5 6) (list 1 3 3 77))
(caesar_encrypt_list (list 0 3 0 1 1 9 8 9) (list 2 0 1 4))
(caesar_encrypt_list (list 9 0 0 7 1 1 9 2) (list 1 9 9 9))
