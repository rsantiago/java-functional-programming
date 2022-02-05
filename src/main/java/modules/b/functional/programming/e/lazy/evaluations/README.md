#Lazy Evaluations
Refer to the facts that lambdas are defined in a place and executed later in time, when needed.
Important to avoid unneeded computations.

```
    Function<int,int> myFun = a -> a+1; // defined here
    ...
    ...
    ...
    if(someCondition()) {
        myFun.apply(10); // evaluate in a lazy time if needed
    }
```