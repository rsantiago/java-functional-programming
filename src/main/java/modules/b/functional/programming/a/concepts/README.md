#Functional Programming
## Important things to notice:
- Functional programming is a programming paradigm in which the program takes pure mathematical functions as objects.
- Makes calculations/projections from provided data
- It doesnt modify external values or environments
- It doesnt modify objects
- Immutable algorithms
- Declarative - tells the program what to do
- Makes use of expressions

## Important operations within the functional programming world:
- You can pass functions to functions
- You can have a function returned from a function
- You can create functions within functions

## Key Concepts
### Pure Functions:
- **First Class Citizens** - Functions are 'first class citizens'. They are objects in themselves
- **Pure functions** - Depend only on input parameters and internal algorithms
- **f(x) = y, allways** - The same input will allways give the same result
- **No side effects** - No external data is modified, no IO is made, no argument is changed
- **Short Circuit** - You can substitute any function by its return value with no side effects
- **inputs and outputs** - Allways have both. Void return types or parameters are not allowed in pure functions
- **Clarity** - It (usually) brings clarity of thought, easy to reason about

### High Order Functions
- Functions that take functions as parameters
- Or return functions as the output - or both
- They are the cornerstone of functional programming
- Functions that take lambda expressions are higher order functions