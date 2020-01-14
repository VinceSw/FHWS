#lang racket
;================================== First attempt -----> not working proberly =================================
(define (tuerme-von-hanoi n)
  (define (hanoi n newList originPole sparePole finalPole)
    (if (> n 1)
        (append (hanoi (- n 1) newList originPole finalPole sparePole) (hanoi (- n 1) newList sparePole originPole finalPole) newList)
        (append originPole finalPole newList)
        )
    )
  (hanoi n '() 'a 'b 'c)
  )
;(tuerme-von-hanoi 3)
;===============================================================================================================


;===================================== Second attempt -----> getting better ====================================

(define (tuerme-von-hanoi2 n)
  (define (move n newList . poles)
    (append newList (cond ((= n 0) (cons (car poles) (car (cddr poles))))
          ((> n 0)
           (list (move (- n 1) (car poles) (car (cddr poles)) (car (cdr poles))))
           ;(display (string-append "Scheibe " (number->string n) ": "))
           ;(display (string-append (symbol->string (car poles)) (symbol->string (car (cddr poles)))))
           ;(newline)
           (list (move (- n 1) (car (cdr poles)) (car poles) (car (cddr poles))))
          )
          )
            )
    )
  (move n 'a 'b 'c)
  )

(tuerme-von-hanoi2 3)
;===============================================================================================================

;===============================================================================================================
;============================== Thrid attempt -----> Seems like we're getting there ============================
;======= TODO's:                                                                                         =======
;=======  - Look at the cons (in else statement).                                                        =======
;===============================================================================================================
(define (tuerme-von-hanoi3 n)
  (define (move n newList . poles)
    (cond ((= n 0) (cons (car poles) (car (cddr poles))))
          (else
           (cons (car (move (- n 1) (car poles) (car (cddr poles)) (car (cdr poles)))) (cdr (move (- n 1) (car poles) (car (cddr poles)) (car (cdr poles)))))
           (display (string-append "Scheibe " (number->string n) ": ")) 
           (display (string-append (symbol->string (car poles)) (symbol->string (car (cddr poles)))))
           (newline)
           (cons (car poles) (cdr (move (- n 1) (car (cdr poles)) (car poles) (car (cddr poles)))))
          )
          )
    )
  (move n '() 'a 'b 'c)
  )

;(tuerme-von-hanoi3 3)
;===============================================================================================================