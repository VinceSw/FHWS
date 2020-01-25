#lang racket
(define (anpassen liste)
  (define (iter liste newList)
    (if (null? liste)
        (append newList liste)
        (cond ((odd? (car liste)) (iter (cdr liste) newList))
              ((equal? (remainder (car liste) 10) 0) (iter (cdr liste) (append newList (list (quadrat (car liste))))))
              (else (iter (cdr liste) (append newList (list (car liste)))))
              )
        )
    )
  (iter liste '())
  )



(define (quadrat x)
  (* x x))

(anpassen '(5 9 10 12 20))