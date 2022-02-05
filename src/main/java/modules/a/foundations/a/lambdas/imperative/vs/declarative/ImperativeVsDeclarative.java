package modules.a.foundations.a.lambdas.imperative.vs.declarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        // imperative
        thisIsImperative();
        thisIsDeclarativeOrFunctional();
    }

    private static void thisIsDeclarativeOrFunctional() {
        int sum = IntStream.rangeClosed(0, 99)
                .filter(i -> i % 2 == 0)
                .reduce(Integer::sum)
                .getAsInt();
        System.out.println(sum);
    }

    private static void thisIsImperative() {
        int sum = 0;
        for (int i=0; i<100; i++) {
            if(i%2==0) {
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
