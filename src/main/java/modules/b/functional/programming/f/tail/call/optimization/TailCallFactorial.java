package modules.b.functional.programming.f.tail.call.optimization;

public class TailCallFactorial {
    public static void main(String[] args) {
        int factor = factorNonOptimized(10);
        // java can't transform an optimized function into an iteration.
        // the idea of tail call refactoring is that, whenever there isn't inner variables to guard
        // we can turn recursive calls into iterations, with no load on the stack
        int optimized = factorOptimized(10, 1);

        System.out.println("factor = " + factor);
        System.out.println("opt = " + optimized);
    }

    private static int factorOptimized(int factor, int currentResult) {
        if(factor==1) return currentResult;
        return factorOptimized(factor-1, factor*currentResult);
    }

    private static int factorNonOptimized(int i) {
        if(i==1) { return 1; }

        // uses the stack to wait for the recursion result
        return i * factorNonOptimized(i-1);
    }


}
