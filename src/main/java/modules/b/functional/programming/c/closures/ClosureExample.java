package modules.b.functional.programming.c.closures;

public class ClosureExample {
    public static void main(String[] args) {
        int age = 22;
        // age =21; // if you do this, then the code won't compile,
        // because a 'free variable' must be final or have a final effect in closures

        // a closure is a function
        Runnable r = () -> {
            // that refers to a free variable (age) in its lexical context
            System.out.println("Age is " + age);
        };

        callRunnable(r);
    }

    private static void callRunnable(Runnable r) {
        // and the free variable 'age' can be accessed from here.
        r.run();
        // strange isnt it?
    }


}
