import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Fibonacci f1Recursion = new Fibonacci(false);

Long sixth =   f1Recursion.getNthFib(5);



System.out.println(sixth);
//        public long getNthFib(int n) {
//            if (n <= 1) {
//                return  n;
//            }
//            return (getNthFib(n-1)) + (getNthFib(n-2));
//        }
    }


}