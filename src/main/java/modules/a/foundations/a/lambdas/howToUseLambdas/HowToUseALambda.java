package modules.a.foundations.a.lambdas.howToUseLambdas;

public class HowToUseALambda {
    public static void main(String[] args) {
        asAnAnonymousRunnableLambda();
        lambdaUsedAsAType();
        declaringFunctionsThatReceiveLambdasAndCalingThem();
        usingLambdasWithParameters();
    }

    private static void usingLambdasWithParameters() {
        AFunctionalInterfaceWithParameters func = (a, b, c) -> System.out.println(c + (a+b));
        func.functionWithParams(1, 3, "Soma = ");
    }

    private static void declaringFunctionsThatReceiveLambdasAndCalingThem() {
        letsReceiveALambda(
                ()->System.out.println("Hey, I am the first lambda, 'functionality on the fly'"),
                ()-> false);

        letsReceiveALambda(()->System.out.println("whatever I want"),
                () -> { System.out.println("Anything I want before returning"); return true; });
    }

    private static void lambdaUsedAsAType() {
        MyFunctionalInterface myFunc = () -> System.out.println("I work!");
        myFunc.func();

        AnotherInterface another = () -> { System.out.println("another"); return true; };
        boolean b = another.functionToBeCalled();
        System.out.println("Return from lambda is " + b);
    }

    private static void asAnAnonymousRunnableLambda() {
        Thread t = new Thread(()-> System.out.println("hello world"));
        t.start();
    }

    private static void letsReceiveALambda(MyFunctionalInterface f1, AnotherInterface f2) {
        f1.func();
        System.out.println("this is the function calling a lambda and returning what? Returning: "+f2.functionToBeCalled());
    }
}
