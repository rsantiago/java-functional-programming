#Optional Values   
- They are here to avoid the existance of NullPointerExceptions
- Models the presence or absence of values
- Very interesting to be used in IO operations, database operations, anything that might return null values
- Exists to hold the dev from dealing with null pointers directly, ensuring he goes through checking the null
- It consumes 15 bytes of memory + the value that it holds
- It is immutable.
```
Optional<String> optString = Optional.of("my existing string");
important methods:
- opt.ifPresent(val -> doSomething(val));       // lambda to do something with the value
- opt.isPresent()                               // check if it has a value
- opt.get()                                     // get value
- opt.isEmpty()                                 // checks if optional has a value
- opt.orElseThrow(() -> new Exception())        // checks if value exists, or throw exception
- Optional.of(something())                      // creates optional from non null source
- Optional.ofNullable(nullableMethod())         // creates optional from method that may return null
- Optional.empty()                              // creates optional with null value 
```
These are the main ones, and Optional also accepts Streaming interfaces.

---
#When To Avoid Using Optional

Optionals might pollute the code, for example, when you have methods that deals with too many arguments.
On those cases, maybe you will want to create an object to encapsulate the parameters, and setting Optional on the ones that might be null.

Beware, though, that even on that case, you might end up with lots and lots of if/else statements and weird condition checking.

What to do on that case? Just eliminate the Optional interface or just keep it very simple, using as few nested ifs as possible.
