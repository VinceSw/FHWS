#lang racket
(define (compress liste)
  (compress-iter liste (list) "" 1))

(define (compress-iter liste newList temp counter)
  (if (null? liste)
      (reverse (flatten newList))
      (if  (eq? (car liste) temp)
           (if (> counter 1)
               (compress-iter (cdr liste) newList temp counter)
               (compress-iter (cdr liste) (cons (flatten (countFollowingIdent liste (car liste) 1)) (cdr newList)) temp (+ counter 1))
               )
           (compress-iter (cdr liste) (cons (car liste) newList) (car liste) 1)
           )
      )
  )
  
(define (countFollowingIdent l temp n)
  (if (null? l)
      (cons temp n)
      (if (eq? (car l) temp)
          (countFollowingIdent (cdr l) temp (+ n 1))
          (cons temp n)
          )
      )
  )


; ============================= Beispiele =============================

(compress '(a b c))
(compress '(a b b c c c))
(compress '(a b b c c c a b c))
(compress '(a a a a a a a a a a))
(compress '())


