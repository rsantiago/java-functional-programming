package modules.c.streams.f.flat.maps;

import java.util.stream.Stream;

public class FlatMapExamples {
    public static void main(String[] args) {
        streamOfStreams();
        wordStreamFromMultilineText();
    }

    private static void wordStreamFromMultilineText() {
        String multiLine = """
                This is indeed
                a multiline text
                made to test 
                the flatmap method
                """.trim();
        Stream.of(multiLine.split("\n"))
                .flatMap(x -> Stream.of(x.split(" ")))
                .map(x -> (String)x)
                .filter(x -> x.length() > 3)
                .forEach(System.out::println);
    }

    private static void streamOfStreams() {
        Stream<String> elements1 = Stream.of("water", "fire");
        Stream<String> elements2 = Stream.of("earth", "air");

        Stream.of(elements1,elements2)
                .flatMap(x -> x) // map the element to a stream,
                // so that it is possible to iterate over those elements
                // as they were simple elements in a flat set
                .map(x->x.substring(0, 3))
                .forEach(System.out::println);
    }
}
