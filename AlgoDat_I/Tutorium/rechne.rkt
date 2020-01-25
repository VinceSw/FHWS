#lang racket
(define (rechne daten operationen)
  (define (iter daten op opTemp newList) 
    (if (null? daten)
        newList
        (if (null? opTemp) 
            (iter (cdr daten) op op (append newList (list (car daten))))
            (if ((car (car opTemp)) (car daten))
                (iter (cdr daten) op op (append newList (list ((cdr (car opTemp)) (car daten)))))
                (iter daten op (cdr opTemp) newList)
                )
            )
        )
    )
  (iter daten operationen operationen '())
  )


(define (quadrat x) (* x x))
(define (minus x) (- x))
(define ops (list (cons odd? quadrat) (cons even? minus)))
(rechne '(1 2 3 4 5) ops)