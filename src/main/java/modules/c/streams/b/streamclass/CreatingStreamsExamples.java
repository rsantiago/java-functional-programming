package modules.c.streams.b.streamclass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingStreamsExamples {
    public static void main(String[] args) {
        usingStreamClass();
        usingArraysClass();
        streamFromMaps();
        streamFromBuilder();
    }

    private static void streamFromBuilder() {
        List<String> collected = Stream.builder()
                .add(1)
                .add(2)
                .add(3)
                .build()
                .map(x -> "Numero: " + x)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Incrivel: " + collected);
    }

    private static void streamFromMaps() {
        Map<Integer,String> myMap = Map.of(
                1, "Bola",
                2, "Bicho",
                3, "Besta",
                4, "Aracaju");

        Stream<Map.Entry<Integer, String>> entrySetStream = myMap.entrySet().stream();
        entrySetStream.map(x -> "" + x.getKey() + ": " + x.getValue())
                .forEach(System.out::println);

        // streams from keys or values
        Stream<Integer> keyStream = myMap.keySet().stream();
        Stream<String> valueStream = myMap.values().stream();

    }

    private static void usingArraysClass() {
        // notice the IntStream and Stream created from different array types
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4});
        stream
                .filter( x -> x>1)
                .forEach(System.out::println);

        Stream<Integer> boxedStream = Arrays.stream(new Integer[]{1, 2, 3, 4});
        boxedStream.forEach(System.out::println);
    }

    private static void usingStreamClass() {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList()); // just collecting

        Stream.of("Rodrigo", "Roberto", "Roberta", "Raquel", "Rita")
                .filter(x -> x.startsWith("Ro"))
                .forEach(System.out::println); // iterating with a consumer
    }
}
