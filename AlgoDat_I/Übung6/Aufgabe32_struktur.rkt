#lang racket
(define nil (list))

(define struktur1
  (cons
   (cons
    24
                    
    (cons 1 2)
    )
   (cons
    20
    (cons 1 1)
    )
   )
  )

(define struktur2
  (cons 
   (cons (list 7)
         (cons (list 2)
               (cons (list 3)
                     (cons (list 1) nil)
                     )
               )
         )
   nil)
  )

(define struktur3
  (cons
   (cons (list 3)
         (cons (list 3) nil)
         )
   (cons (list 3)
         (cons (list 3)
               (cons (list 3) (list 3))
               )
         )
   )
  )

(define struktur4
  (cons
   (cons
    (cons nil
          (cons 6
                (cons 1
                      (cons 0
                            (cons 2 4)
                            )
                      )
                )
          )
    (cons 3 3)
    )
   (cons 10
         (cons 7
               (cons 8
                     (cons 9
                           (cons 3 nil)
                           )
                     )
               )
         )
   )
 )