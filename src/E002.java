/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #2
 *
 * Each new term in the Fibonacci sequence is generated by
 * adding the previous two terms. By starting with 1 and 2,
 * the first 10 terms will be:
 *                 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values
 * do not exceed four million, find the sum of the even-valued terms.
 *
 */

public class E002 {

    public static void main(String[] args) {
        int fib_0 = 1;
        int fib_1 = 2;
        int fib_current = 3;
        int sum = 2;

        while (fib_current < 4000000) {
            if (fib_current % 2 == 0)
                sum += fib_current;
            fib_0 = fib_1;
            fib_1 = fib_current;
            fib_current = fib_0 + fib_1;
        }

        System.out.println(sum);
    }
}
