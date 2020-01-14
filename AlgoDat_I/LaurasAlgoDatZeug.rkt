#lang racket
(define (removeFirstLast string)
  
(cond ((null? (string->list string)) "")
       (else (substring string 1 (- (string-length string) 1)))))
 ; (substring string 1 (- (string-length string) 1)))
     ;  (removeFirstLast "")
(define ( iter passwort counter1 counter2 )
      (cond ((and (>= counter1 2) (>= counter2 2)) #t )
            ((null? passwort) #f)
            ((not (char-alphabetic? (car passwort))) (iter (cdr passwort) (+ counter1 1) counter2))
            ((char-upper-case? (car passwort)) (iter (cdr passwort) counter1 (+ counter2 1)))
           ; ((null? passwort) #f)
            (else (iter (cdr passwort) counter1 counter2))))
      
(define (sicheresPasswort passwort)
(if (< (string-length passwort) 7) #f 
  (iter (string->list passwort) 0 0)))
 ;(sicheresPasswort "aUljsb!f/KasDhf")
;(sicheresPasswort "ABC123")
;(sicheresPasswort "abdddklsdi")

  (define (iter-a anagramm string string1)
    (cond ( (null? anagramm) #t)
          ;((= counter laenge) #t)
          ((null? string) #f)
          ((eq?  (car anagramm) (car string)) (iter-a (cdr anagramm) string1 string1))
          (else (iter-a anagramm (cdr string) string1))))



(define (isAnagramm anagramm string)
  (if (not (eq? (string-length anagramm) (string-length string))) #f
      (if (eq? (iter-a (string->list (string-upcase anagramm)) (string->list  (string-upcase string)) (string->list (string-upcase string)))
          (iter-a (string->list (string-upcase string)) (string->list  (string-upcase anagramm)) (string->list (string-upcase anagramm)))) #t #f)))
      
(isAnagramm "Desperation" "A rope ends it")
(isAnagramm "Eleven plus two" "Twelve plus one")
(isAnagramm "aaa" "cca")


