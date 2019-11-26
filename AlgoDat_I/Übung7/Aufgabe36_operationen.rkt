#lang racket

(define (operation operationen n)
  (lambda (zahlListe) (operate zahlListe operationen n)))

(define (operate zahlListe operationen n)
  (if (= n 1)
      ((car operationen) (car zahlListe) (car (cdr zahlListe)))
      (operate zahlListe (cdr operationen) (- n 1))))



;================================ Beispiele ================================

(define plus (operation (list + - * /) 1))
(plus (list 1 2))

(define minus (operation (list + - * /) 2))
(minus (list 1 2))

(define geteilt (operation (list + - * /) 4))
(geteilt (list 10 5))