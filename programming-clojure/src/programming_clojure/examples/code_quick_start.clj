(ns programming-clojure.examples.code-quick-start)

; let’s create a few variants of “Hello World.”
(println "Hello World")

; encapsulate into a function
(defn hello [name] (str "Hello, " name))
(hello "Stu")

; defining a set
#{}

; conjoin an element onto a set to see that a new set is created:
(conj #{} "Stu")

;Use atom to create an atom, and use def to bind the atom to the name visitors:
(def visitors (atom #{}))

; Try to swap! a visitor into visitors, using conj as the update function:
(swap! visitors conj "Stu")

; At any time, you can peek inside the ref with deref or with the shorter @:
(deref visitors)
@visitors

; more ellaborate version of hello:
(defn hello
  "Writes hello message to *out*. Calls you by username.
  Knows if you have been here before."
  [username]
  (swap! visitors conj username)
  (str "Hello, " username))

; check visitors track
; (hello ​"Aaron"​)
; (hello ​"Stu"​)
; (hello ​"Rich"​)

; @visitors
