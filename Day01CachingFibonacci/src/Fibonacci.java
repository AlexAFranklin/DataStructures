import java.util.HashMap;

class Fibonacci {

    private boolean isCacheOn;
    private HashMap<Integer, Long> fibsCached = new HashMap<>();

    private int fibsCompCount = 2; // may not be needed
    private int fibsComputed = 0;
    // in a correct caching implementation fibsCompCount will end up the same as fibsCached.size();

    Fibonacci(boolean cacheOn) {
        isCacheOn = cacheOn;
        fibsCached.put(0, 0L); // #0
        fibsCached.put(1, 1L); // #1
    }


    // when you implement caching, make this method print out the number of fib values it had to compute (as opposed to take from cache)
//    public long getNthFib(int n) {
//        if (n < 0 ) {
//            throw new IllegalArgumentException("Not negative fibonacci exists");
//        }
//        if (fibsCached.containsKey(n) && isCacheOn){
//            return fibsCached.get(n);
//        } else if(!fibsCached.containsKey(n)) {
//            System.out.println("Fibs computed: " + ++fibsComputed);
//        }
//        if (n <= 1) {
//            return  fibsCached.get(n);
//        }
//
//        return (isCacheOn) ? computeNthFib(n-1) + computeNthFib(n-2) : getNthFib(n - 1) + getNthFib(n - 2);
//    }

        public long getNthFib(int n) {
        if (n < 0 ) {
            throw new IllegalArgumentException("Not negative fibonacci exists");
        }
        return computeNthFib(n);
}

//    private long computeNthFib(int n) {
//        fibsCached.put(n, getNthFib(n));
//        fibsCompCount++;
//        return fibsCached.get(n);
//    }

    private long computeNthFib(int n) {
        if (isCacheOn && fibsCached.containsKey(n)){
            return fibsCached.get(n);
        }

       if (n <= 1) {
           return n;
       }
       fibsComputed++;
        System.out.println("cached " + fibsComputed);
       long nthFib = computeNthFib(n-1) + computeNthFib(n-2);
       if (isCacheOn) {
           fibsCached.put(n, nthFib);
       }

       return nthFib;
    }

    // You are allowed to add another private method for fibonacci generation
    // if you want to use recursive approach. I recommend non-recursive though.

    // How many fibonacci numbers has your code computed as opposed to returned cached?
    // Use this in your testing to make sure your caching actually works properly.
    public int getCountOfFibsComputed() {
        return fibsCompCount;
    }

    @Override
    public String toString() {

return "fibsCached";

    } // returns all cached Fib values, comma-space-separated on a single line

}