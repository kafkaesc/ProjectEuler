/**
 * Created by jared on 10/6/15
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * F[n] = F[n−1] + F[n−2], where F[1] = 1 and F[2] = 1.
 *
 * Hence the first 12 terms will be:
 *
 * F[1] = 1
 * F[2] = 1
 * F[3] = 2
 * F[4] = 3
 * F[5] = 5
 * F[6] = 8
 * F[7] = 13
 * F[8] = 21
 * F[9] = 34
 * F[10] = 55
 * F[11] = 89
 * F[12] = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence
 * to contain 1000 digits?
 *
 */

import java.math.BigInteger;
import java.util.HashMap;

public class E025 {
    private static int largestIndex;
    static private HashMap<Integer, BigInteger> fibCache;

    public static void main(String[] args) {
        setCache();
        boolean found = false;
        for(int i = 1; i < 10000 && !found; i++) {
            // I have to return x twice. Even though it's the same object
            // it returns as 1000 the first time. This bug is weird af.
            int x = fibonacci(i).toString().length() ;
            x = fibonacci(i).toString().length();
            if(x == 1000) {
                found = true;
                System.out.println(i);
            }
        }
    }

    private static BigInteger fibonacci(int index) {
        if(index < 1)
            throw new IllegalArgumentException("Argument must be 1 or greater.");

        if(fibCache.containsKey(index))
            return fibCache.get(index);

        int it = largestIndex;
        BigInteger fib_a = fibCache.get(it - 2); //new BigInteger(bigHelper(fibCache[CACHE_SIZE - 2]));
        BigInteger fib_b = fibCache.get(it - 1); //new BigInteger(bigHelper(fibCache[CACHE_SIZE - 1]));
        BigInteger fibonacciValue = new BigInteger(fib_a.add(fib_b).toString());

        while(it <= index) {
            fib_a = new BigInteger(fib_b.toString());
            fib_b = new BigInteger(fibonacciValue.toString());
            fibonacciValue = new BigInteger(fib_a.add(fib_b).toString());
            it++;
            fibCache.put(it, fibonacciValue);
            if(it > largestIndex)
                largestIndex = it;
        }
        return fibonacciValue;
    }

    private static String bigHelper(int n) {
        return ((Integer)n).toString();
    }

    private static void setCache() {
        fibCache = new HashMap<Integer, BigInteger>();
        fibCache.put(1, new BigInteger("1"));
        fibCache.put(2, new BigInteger("1"));
        fibCache.put(3, new BigInteger("2"));
        fibCache.put(4, new BigInteger("3"));
        largestIndex = 4;
    }
}
