package modules.c.streams.d.primitive;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreamExmples {
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3)
                .mapToInt(x -> x) // parse to a primitive intstream
                .boxed() // parse to the boxed type Integer stream
                .filter(x -> x < 4)
                .collect(Collectors.toList());
        print("We got a collection = " + collect);

        OptionalInt max = IntStream.of(1, 2, 3).max();
        print("Max = " + max.getAsInt());

        OptionalInt min = IntStream.of(1, 2, 3).min();
        print("Min = " + min.getAsInt());

        int sum = IntStream.of(1, 2, 3).sum();
        print("sum = " + sum);

        OptionalDouble average = IntStream.of(1, 2, 3).average();
        print("Avg = " + average.getAsDouble());

        IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 3).summaryStatistics();
        print("Summary = " + summaryStatistics);
    }

    private static void print(String msg) {
        System.out.println(msg);
    }
}
