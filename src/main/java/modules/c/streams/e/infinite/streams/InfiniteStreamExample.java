package modules.c.streams.e.infinite.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreamExample {
    public static void main(String[] args) {
        fromIterator();
        fromGenerator(() -> "Hey, new element!");
        fromGenerator(new Random()::nextInt);
    }

    private static<T> void fromGenerator(Supplier<T> stringSupplier) {
        Stream.generate(stringSupplier)
                .limit(10) // optional
                .forEach(System.out::println);
    }

    private static void fromIterator() {
        IntStream.iterate(1, x->x+1)
                .limit(20) // optional
                .forEach(System.out::println);
    }
}
