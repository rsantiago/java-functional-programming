# Streams

- Facilitates iterations and a series of **piped operations** on any data source
- **Streams are LAZY**: each item goes through all the pipeline before the next item is processed.
- Operations:
  - Filtering
  - Mapping to other object types and data structures
  - Peeking (using) the objects in some way
  - Reducing to a simpler data structure
  - Extracting a stream from an element (flatmaps, see bellow)
  - Collecting the results
- **Declarative**: Allows to just tell what to do in a clear way
- **Flexible**: the operations can be rearranged easily with no side effects
- **Parallelizable**: you can create concurring threads with no effort - calling parallel() on a Stream object
- **Not Data Containers**: Streams can be used only once, since they are not data collections.
- **Immutable**: you can't change the state of a stream from the outside. Either you use it or not.
- Streams create **new streams** after each intermediate operation (see bellow).

```
Pseudo-code Example:

    // this is also called a "Stream Pipeline"
    from().any().datasource()
        .stream().parallel()
        .filter(::onlySpecificPredicates)
        .peek(::onlySeeTheVariableAndDoSomething)
        .map(::toAnotherType)
        .reduce(::reducingOperation)
        .collect(toAFinalList())

```

---

### Stream Pipeline Structure

- Source data
- Zero or more Intermediate Operations
- Terminal Operation (a result or side effect)

---

### Streams Higher Order Functions

Remember, higher order functions are those that takes 1+ functions as arguments, and/or returns a function. Here are some examples:

- **filter()** - an *if* in functional programming - It takes a `Predicate<T>` and returns the list of items that returns `true` for the test.
- **map()** - Maps an object into another objet in the stream.
- **reduce()** - Helps to project a whole stream into a single variable (sums, averages etc)
- **flatMap()** - Helps iterating over a stream created from a stream object (see bellow)

---

### Stream Class

It allows creating streams from varargs of any type: integers, strings, objects, whatever.

See example in StreamClassExamples class.

---

### Reducers

These are operations that start with an **identity value** and executes a series of operations throught the elements of the stream, to reduce them all into a single value.

An **Identity Value** is a neutral element that can be applied to the next reduce operations and does NOT change the result of the stream processing.

Examples:

- In a series of sums, adding 0 does not change the result of the operation.
- In a series of multiplications, multiplying by 1 does not change the result of the operation.
- In a series of string concatenations, adding "" does not change the result of the strings joining.

---

### Primitive Streams

Java presents us with some specific primitive stream types.

- Types
  - IntStream
  - DoubleStream
  - LongStreams
- Why using them?
  - They will take an object representing any one of these types and will cast them to the primitive type, effectively unboxing the Object.
    - Method mapToXXX() (Int, Double, Long)
  - They provide other utility methods to deal with primitive numeric data. For instance:
    - max() - gets the maximum value
    - min() - gets the minimum value
    - average() - returns the average value of the whole stream
    - mapToObj() - returns any object type from a primitive type
    - boxed() - returns the boxed version of the type
    - count() - count the element numbers
    - summaryStatistics() - Get different statistics data for the collection - min, max, average etc

---

### Bounded or Finite Streams

Those are streams created by a very definite set of elements.
It is usually created from Streams.of() class.

```
  Stream.of(1, 2, 3).forEach(/* do whatever */);
```

---

## Infinite Streams

### Iterator

This is a stream defined by a seed and an operator that calculates the next element. You can keep getting new elements from the streams.
If you don't `limit()` the stream, then you will have an endless loop, basically.

```
  IntStream.iterate(0, x->x+1)
  .limit(20) // optional, so that the stream stops after getting a set of this elements size
  .forEach( /* do something with each element */);
```

### Generator

This stream is generated by calling a supplier on each iteration.

```
  Stream.generate(() ->"New Element!").forEach(/* do whatever */);
```

---

## FlatMap

When you have a stream of streams, you can 'flatten' it to iterate over all the sub elements using the flatMap() method.

- flatmap() expects to receive a Stream of elements.

Sometimes, you can create a whole stream from an individual element in a stream. At these times, flatmap is also suitable to get those stream elements and process individually in the basic, 'flat' pipeline.

---

## Parallel

Only try to use parallel optimization if the cost of doing the sequential process is unbearable.

You can parallelize the stream effortlessly, by calling the parallel() function into a stream.
The stream may be executed much faster (sometimes not), although you have to provide the following guarantees:
- Stateless - The processing should not depend on outside information while the processing is occuring
  - Example, by using `skip(2)` method, your parallel stream may access the temporary element index concurrently, and it will not be able to iterate correctly throughout the stream every single time.
- Non interfering - The process should not alter outside data 
- Associative - The order of processing is not relevant. Processing elements at any order will issue the same results.

Parallel processing is done with fork() & join() pool, so it does not check for synchronization or visibility issues.

It may add lots of complexity to the code.

### Selecting the amount of processors to use

Here is how you set up the amount of processors to be used in parallel operations:
```
  // peeks into the number of processors available
  int processors = Runtime.getRuntime().availableProcessors();
  System.out.println("Processors: " + processors);
  
  // setting the amount of processors to be used
  System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", String.valueOf(2));
  
  // gets how many processors are being currently used on pararallel operations
  System.out.println("Thread count: " + ForkJoinPool.getCommonPoolParallelism());
  
  // If you don't set any number of processors, the default is processors-1 (1 thread is allways used in the main() method.        
```

### How many processors should I use?
- IO-intensive operations (database, network, file io) - it is recommended to spawn more threads than available processors, since many threads will be sleeping, waiting for data.
- CPU intensive computations - it is recommended to use up to the number of cores the computer has. 
