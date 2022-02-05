package modules.a.foundations.b.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class BasicFunctionalInterfaces {
    public static void main(String[] args) {
        predicate();
        consumer();
        supplier();
        function();
        unaryOperator();
        binaryOperator();
        biPredicate();
        biConsumer();
        biFunction();

        // check specialized functional interface types
        specializedIntBinaryOperator();
    }

    private static void specializedIntBinaryOperator() {
        IntBinaryOperator sum = (x,y) -> x+y;
        System.out.println(sum.applyAsInt(1, 2));
    }

    private static void biFunction() {
        BiFunction<String, Integer, List<String>> stringMultiplier = (x, y) -> {
            List<String> stringList = new ArrayList<>();
            IntStream.range(1,y)
                    .forEach( i -> stringList.add(x));
        return stringList;
        };
        List<String> multiplied = stringMultiplier.apply("Multiplied", 10);
        multiplied.forEach(System.out::println);
    }

    private static void biConsumer() {
        BiConsumer<String, Integer> consumeTwoThigns = (x, y) -> System.out.println("This is the string, appended with an int " + x + y);
        consumeTwoThigns.accept("Append this to an int: ", 10);
    }

    private static void biPredicate() {
        BiPredicate<String, Integer> isOfLength = (x,y) -> x.length() == y;
        boolean maybe40 = isOfLength.test("I dont know the length of this string", 40);
    }

    private static void binaryOperator() {
        BinaryOperator<Integer> multiply = (x, y) -> x*y;
        Integer multResult = multiply.apply(3, 4);
    }

    private static void unaryOperator() {
        UnaryOperator<String> stringAppend = x -> x + " this was appended";
        String appResult = stringAppend.apply("Whatever - ");
    }

    private static void function() {
        Function<String, Integer> countLength = x -> x.length();
        Integer clResult = countLength.apply("What length is this string?");
    }

    private static void supplier() {
        Supplier<String> stringSupplier = () -> "Today is what?";
        String produced = stringSupplier.get();
    }

    private static void consumer() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("This string");
    }

    private static void predicate() {
        Predicate<String> myPredicate = x -> x.equals("This string here");
        boolean testResult = myPredicate.test("whatever");
    }
}
