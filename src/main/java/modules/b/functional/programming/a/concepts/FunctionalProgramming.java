package modules.b.functional.programming.a.concepts;

import java.util.function.Supplier;

public class FunctionalProgramming {
    public static void main(String[] args) {
        StringAppender stringAppender = myAppendFunction(() -> "This string first",
                () -> 123,
                () -> new StringBuilder());
        String newString = stringAppender.append("I want to append a string in the end");
        System.out.println("String is " + newString);
    }

    private static StringAppender myAppendFunction(
            Supplier<String> firstSupplier,
            Supplier<Integer> secondSupplier,
            Supplier<StringBuilder> builderSupplier) {
        return anotherString ->
                builderSupplier.get()
                    .append(firstSupplier.get())
                    .append(" - ")
                    .append(secondSupplier.get()).append(" - ")
                    .append(anotherString)
                    .toString();
    }

    @FunctionalInterface
    interface StringAppender {
        String append(String yetAnotherString) ;
    }
}
