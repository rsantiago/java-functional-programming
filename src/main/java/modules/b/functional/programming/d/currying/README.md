# Currying

Currying is a technique in which a multi-parameter function is reestructured into a series of functions that takes one parameters, each.

```
    // take this pseudo code as an example
    F(A, B, C) = X+Y
    // equals to
    F(A) + F(B) + F(C) = X+Y
    // therefore
    F(A, B, C) = F(A) + F(B) + F(C)
```
This is what currying is. It turns possible to have a 1-variable function and get several variables in sequence.