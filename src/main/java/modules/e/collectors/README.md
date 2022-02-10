# Collectors
- Terminal Analogous Collectors - They are used to collect the elements after the stream being processed.
    - Collectors.toList() - The output is a list
    - Collectors.toSet() - The output is a set
    - Collectors.toMap() - Creates a map from any key/value extracted from the stream element
    - Collectors.toCollection() - Creates any kind of collection to store values from the stream
    - Collectors.partitioningBy() - Partitions a stream into two collections using a predicate 
    - Collectors.groupingBy() - Groups the stream elements into separate lists, one by each unique key mapped from each element
    - Collectors.toUnmodifiableCollection() - Groups the collection into unmodifiable collections
    - Collectors.joining() - Creates a string appended from a list of Strings mapped from the stream
- Downstream - 
  - Cascading - in a groupingBy collector:
    - Collectors.counting() - counts the number elements 
    - Collectors.summingDouble() - Sums double values mapped from the elements
    - Collectors.maxBy(Comparator.comparing()) - Retrieve the stream element in a group with the maximum value for a field
    - Collectors.mapping() - transforms the object into another object, receives the mapping function and a new Collector
## Concept

- A collector is an interface capable of reducing the objects stream into a collection.
- use collect() as the terminal stream operation and pass a collector as a parameter
- Collectors.xxx() offers different data structures to collect your terminal stream results

## How does a Collector work internally

A Collector is an interface with the following higher order functions:
- supplier() - takes a Supplier as argument - used to create the container that collects the results (list, maps, accumulator for sums)
- accumulator() - takes a BiConsumer as argument - receives the container and the element to be collected. The accept() implementation inserts the element into the container.
- combiner() - takes a BinaryOperator as argument - combines results in parallel operations, from different cpus
- finisher() - takes a Function as argument - returns the final collector object - receives the container and creates the final container object.
- characteristics() - takes a Set as argument - decides which steps of the stream should be executed

## Creating a Custom Collector
A Basic CollectorImpl<> can be constructed with Collector.of() method to take the lambdas as parameters and build a new kind of collector. It receives all lambdas in the constructor. Optionally, you can ommit the finish lambda, in case the final list doesn't need to be transformed. Remember to change the characteristics to IDENTITY_FINISH in case you don't need to use the finish function - or return the adequate characteristics accordingly.

