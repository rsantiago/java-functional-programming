package modules.b.functional.programming.d.currying;

import java.util.function.Function;

public class CurryingExample {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> firstFunction = a -> b -> a+b; // a function returning a function
        Function<Integer, Integer> secondFunction = firstFunction.apply(10);

        int curryingResultSum = secondFunction.apply(20);

        print(curryingResultSum);

        int anotherSum = secondFunction.apply(10);
        print(anotherSum);

        Function<Integer, Integer> thirdFunction = firstFunction.apply(33);
        int yetAnotherSum = thirdFunction.apply(5);
        print(yetAnotherSum);

    }

    private static void print(int curryingResultSum) {
        System.out.println(curryingResultSum);
    }
}
