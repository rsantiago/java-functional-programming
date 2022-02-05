#Important Things To Remember

- Basic utilitary functional interfaces are already defined in the package `java.util.functions`
---
## Basic Predefined Funcional Interfaces in Java
- **Predicate\<T\>**: `boolean test(T)` - Used to test conditions, accept one parameter, returns boolean
- **Consumer\<T\>**: `void accept(T)` Consumes something, returns nothing 
- **Supplier\<T\>**: `T get()` - Accepts nothing, returns something
- **Function\<T,R\>**: `R apply(T)` - Accepts a type, returns another type
---
###Other important predefined functional interfaces
- **UnaryOperator\<T\>**: `T apply(T)` - Like Functions, except that the return type must match the parameter type
- **BinaryOperator\<T\>**: Accepts two parameters of same type, return the same type
- **BiPredicate\<L,R\>**: Takes two arguments of different types, evaluate condition, returns boolean
- **BiConsumer\<T,U\>**: Takes two arguments of different types, returns nothing
- **BiFunction\<T,U,R\>**: Accepts two arguments, returns a third type
---
###There are important specialized interfaces (Int**, Double** etc), because...
It makes less costly for the processor to avoid the boxing/unboxing cost


