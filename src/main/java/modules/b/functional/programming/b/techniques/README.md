# Important Functional Programming Techniques
- **Function Chaining**: When you can get the return of one function and us it as the argument to a next function. Execution is made in the same order as the function declarations.
- **Functional Composition**: When you can get the output of the latest function and use it as the input of the previous function. Execution is made in the reverse order from the declaration.
- **Closures**: Functions can access variables that are final, declared in the same code block in which the function was declared. 
- **Currying**: When a function that takes N>1 variables as the input is turned into a series of functions that take 1 argument each, and the outputs are used with the outputs of the next 1-argument-input function. F(a + b + c) = F(a) + F(b) + F(c)
- **Lazy evaluation**: A function can be called way after it was declared or passed as an argument. It can even NOT be called at all.
- **Tail Call Optimization**: Optimizing recursive calls so that the result of the former executions are passed as an argument to the latest recursive calls. It releases the stack and makes it possible to turn recursive calls into simple iterators (depends on the programming language).

## Function Chaining

It is accomplished by creating default methods on the functional interface that would take other functions as parameters and return functions that would later call those parameter functions.

Example
```
interface MyChainedFunction {
    String doTheMainFunction(String);
    default MyChainedFunction doTheNextFunction(MyChainedFunction chained) {
        return x -> {
            chained.doTheMainFunction(this.doTheMainFunction(x);
        };
    }
}

// check examples in the code

```

### The predefined functional interfaces have default techniques methods, pre-implemented

- **Function** - compose(), andThen(), identity()
- **UnaryOperator** -  identity()
- **Consumer** - andThen()
- and so on...