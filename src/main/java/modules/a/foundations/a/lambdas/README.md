#Important Basic Things to Remember:

- Creating a lambda doesn't create a new .class file, while creating an anonymous inner class, does.
- Lambda means you can pass 'behaviors as parameters'
- Declarative programming - the programmer says 'what' instead of 'how' to do things
- Lambdas are 'anonymous' implementations of interfaces with 1 method only (called functional interfaces)
- Use @FunctionalInterface to mark the interfaces, and the compiler will complain if there is more than one method in your interface
- Streams are thread safe, because it uses immutable variables
- Functional programming is more readable
- Functions are "first class citizens" in Java, so as classes
- The compiler can guess the types in the parameters, no type declaration is needed 

### Lambas are functions with no:
  - access modifiers
  - return types
  - return keyword (on expression lambdas)
  - parameter names
  - curly brackets (expression lambdas)
  - Function parenthesis (when there is just one parameter variable)

Examples
```
MyLambda l = () -> System.out.println("see? Easy!");
l.whatever();

AnotherLambda al = (a, b) -> a+b;
int sum = al.somefunc(3, 2);

OneParameterOnly oneParam = x -> System.out.println("myparam: "+x);
oneParam.func("Whatever"); // the compiler can figure out the types to match the interface declaration

MultipleLinesLambda mult = () -> {
                                System.out.println("first line");
                                System.out.println("second");
                                System.out.println("third");
                                return 100;
                            };
mult.myFuncName();                        
```

