package modules.a.foundations.c.method.references;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReference {
    public static void main(String[] args) {
        // constructor reference
        Supplier<SecretNumberAdder> builder = SecretNumberAdder::new;

        // building an object with a functional interface
        SecretNumberAdder secretNumberAdder = builder.get();

        // using a consumer to reference an instance method
        Consumer<Integer> secretNumberSetter = secretNumberAdder::setSecretNumber;
        secretNumberSetter.accept(6);

        // using unary and binary operator to reference instance methods
        BinaryOperator<Integer> secretAddTwo = secretNumberAdder::addTwoArguments;
        UnaryOperator<Integer> secretAddOne = secretNumberAdder::addOneArgument;

        int oneAdded = secretAddOne.apply(10);
        int twoAdded = secretAddTwo.apply(20, 30);

        System.out.println("oneadded = " + oneAdded);
        System.out.println("twoAdded= " + twoAdded);

        int[] ints = IntStream.range(1, 10)
                .mapToDouble(x -> Math.pow(x, 2))
                .mapToObj(x -> getSN(builder, (int)x))
                .mapToInt(SecretNumberAdder::getMySecretNumber) // using a reference method to work with the instances
                .toArray();

        System.out.println(
                Arrays.stream(ints)
                    .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" - ")));

        Function<String, Integer> length = String :: length;
        String s = "this is a string example. Let's see how long is it?";

        System.out
                .print("String length = " + length.apply(s));
    }

    private static SecretNumberAdder getSN(Supplier<SecretNumberAdder> builder, int x) {
        var s = builder.get();
        s.setSecretNumber(x);
        return s;
    }

}

class SecretNumberAdder {
    private int secretNumber;

    public SecretNumberAdder() {

    }

    public int getMySecretNumber() {
        return secretNumber;
    }

    public int addOneArgument(int x) {
        return secretNumber + x;
    }

    public int addTwoArguments(int x, int y) {
        return secretNumber + x + y;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }
}