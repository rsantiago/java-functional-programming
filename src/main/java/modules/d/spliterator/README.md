# Spliterator Interface

- Use it when you want to create a Stream from a custom source

## Methods
- characteristics() - returns an ORed value of all the stream characteristics in this spilterator (see values bellow)
- tryAdvance() - It tries to create an instance of the particular object you are trying to produce with a custom stream
- trySplit() - It tries to create parallel streams from your stream
- 
### Spliterator Characteristics
Used to characterize the state of the stream

- ORDERED: The order of items matters and does not change for this stream
- DISTINCT: All the elements are different in this stream
- SORTED: The elements are sorted on this stream
- SIZED:  The size of the spliterator is known
- NONNULL: There aren't null values on this stream
- IMMUTABLE: The stream is immutable
- CONCURRENT: The stream is built on a concurrent structure
- SUBSIZED: All the parallel streams chunks from the trysplit() method will be sized