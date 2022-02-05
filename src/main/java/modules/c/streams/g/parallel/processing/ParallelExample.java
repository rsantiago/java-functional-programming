package modules.c.streams.g.parallel.processing;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelExample {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors: " + processors);
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", String.valueOf(2));
        System.out.println("Thread count: " + ForkJoinPool.getCommonPoolParallelism());
        unorderedParallelProcessing();
    }

    private static void unorderedParallelProcessing() {
        IntStream.iterate(0, x -> x+1)
                .limit(10)
                .parallel()
                .forEach(System.out::println);
    }
}
