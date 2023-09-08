import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Fibonacci fib1 = new Fibonacci(false);
        Fibonacci fib2 = new Fibonacci(true);

Long recursion =   fib1.getNthFib(16);
Long caching = fib2.getNthFib(16);
System.out.println(fib1.getCountOfFibsComputed() + " Fib 1 fibs computed");
        System.out.println(fib2.getCountOfFibsComputed() + " Fib 2 fibs computed");



System.out.println(recursion + " + " + caching);

    }


}