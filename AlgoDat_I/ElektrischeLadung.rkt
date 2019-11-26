#lang racket
; Berechnen der Elementarladung e eines Elektrons
(define e (* -1.6022 (expt 10 19)))
; Generieren eines Ergebnisstrings indem ein String mit dem Erbebnis kombiniert wird
; -> Zusammenführen von Strings mit string-append und casten von einer Zahl zu einem String number->string
(define resultE (string-append "Elementarladung: " (number->string e)))
resultE
; Berechnen der elektischen Ladung Q von insgesamt 8 Elektronen
(define Q (* 8 (* e -1)))
(define resultQ (string-append "Elektrische Ladung: " (number->string Q)))
resultQ