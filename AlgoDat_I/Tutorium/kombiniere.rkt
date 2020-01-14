#lang racket
(define (kombiniere op)
  (lambda (liste1 liste2) (iter op liste1 liste2 '()))
  )

(define (iter op liste1 liste2 newList)
  (if (and (null? liste1) (null? liste2))
      newList
      (if (null? liste1)
          (iter op '() (cdr liste2) (append newList (list (op 0 (car liste2)))))
          (if (null? liste2)
              (iter op (cdr liste1) '() (append newList (list (op (car liste1) 0))))
              (iter op (cdr liste1) (cdr liste2) (append newList (list (op (car liste1) (car liste2)))))
              )
          )
      )
  )

(define (op a b) (+ a b))
(define func (kombiniere op))
(func '(1 2 3 1 2 3) '(3 4 5))