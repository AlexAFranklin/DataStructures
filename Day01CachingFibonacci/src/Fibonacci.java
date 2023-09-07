import java.util.HashMap;

class Fibonacci {

    private boolean isCacheOn;
    private HashMap<Integer,Long> fibsCached = new HashMap<>();

    private int fibsCompCount = 2; // may not be needed
    // in a correct caching implementation fibsCompCount will end up the same as fibsCached.size();

    Fibonacci(boolean cacheOn) {
        isCacheOn = cacheOn;
        fibsCached.put(0,0L); // #0
        fibsCached.put(1,1L); // #1
    }




    // when you implement caching, make this method print out the number of fib values it had to compute (as opposed to take from cache)
    public long getNthFib(int n) {
        if (fibsCached.containsKey(n)){
            System.out.println("CACHED!! " + n);
            return fibsCached.get(n);
        }
        else {
            System.out.println("DIDN't CACHE: " + n);
        }
        if (n <= 1) {
            return  n;
        }

        fibsCached.put(n-1, getNthFib(n-1));
        System.out.println(fibsCached.get(n -1) + " cached1? " + (n-1));
        fibsCached.put(n-2, getNthFib(n-2));
        System.out.println(fibsCached.get(n -2) + " cached2? " + (n-2));
        return fibsCached.get(n-1) + fibsCached.get(n-2);
    }

    // You can find implementation online, recursive or non-recursive.
    // For 100% solution you should use values in fibsCached as a starting point
    // instead of always starting from the first two values of 0, 1.
    private long computeNthFib(int n) {

        return 0L;
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
return "";

    } // returns all cached Fib values, comma-space-separated on a single line

}