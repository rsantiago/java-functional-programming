package modules.b.functional.programming.b.techniques;

import java.util.Objects;

public class ChainedFunctions {
    public static void main(String[] args) {
        StringsChain chain = x -> x;
        String s = chain.chainIt("What is the music?");

        System.out.println("no chaining result is: " + s);
        // try playing with these chained strings, commenting and de-commenting
        String result = chain
                .glue(ChainedFunctions::anAdventure)
                .glue(ChainedFunctions::allwaysComeFirst)
                .glue(x -> x + " and here comes another string ")
                //.next(x -> x.split("ever")[0])
                //.next(x -> x.split("ever")[1])
                .glue(ChainedFunctions::allwaysComeFirst)
                .chainIt(" Whatever comes to mind ");
        System.out.println(result);
    }

    private static String anAdventure(String x) {
        return x + " what an adventure ";
    }

    private static String allwaysComeFirst(String x) {
        return " This will allways come first " + x;
    }
}

interface StringsChain {

    String chainIt(String s);

    default StringsChain glue(StringsChain chain) {
        Objects.requireNonNull(chain);
        // try commenting one or the other expression and check the difference in the chaining of the functions
        return x -> chaining(chain, x);
        // return x -> composition(chain, x);
        // return crazyRide(chain); // this is a crazy ride
    }

    private String composition(StringsChain outerChain, String x) {
        // Composition - argument is processed before, then this is processed (downside up)
        return chainIt(outerChain.chainIt(x));
    }

    private String chaining(StringsChain outerChain, String x) {
        // chaining - this is processed first, then the argument chain (upside down processing)
        return outerChain.chainIt(chainIt(x));
    }

    private StringsChain crazyRide(StringsChain chain) {
        return x -> x + chain.chainIt(this.chainIt(x));
    }

}
