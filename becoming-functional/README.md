# Becoming Functional Notes

## Chapter 2. First Class Functions

### Anonymous functions

- Anonymous functions are split up into two types, lambda functions and closures.

#### Lambda functions

- Lambda functions are *unnamed* functions that contain a *parameter list*, a *body* and a return.

![Imagem 2.1](notes/images/Screenshot from 2018-05-04 20-41-54.png)
![Imagem 2.2](notes/images/Screenshot from 2018-05-04 20-42-00.png)

#### Closures

- Closures are much like lambda's except they reference variables outside the scope of the function (the *body* references a variable that neither exists in the *body* or the *parameter list*. )

### High Order Functions

- A function becomes “higher order” if it accepts or returns a function.
