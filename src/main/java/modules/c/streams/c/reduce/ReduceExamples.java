package modules.c.streams.c.reduce;

import java.util.stream.Stream;

public class ReduceExamples {
    public static void main(String[] args) {
        Integer sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 7)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);


        Integer mult = Stream.of(1, 2, 3)
                .reduce(1, (x, y) -> x * y);
        System.out.println(mult);


    }
}
