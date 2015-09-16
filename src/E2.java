/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #2
 * By considering the terms in the Fibonacci sequence whose values
 * do not exceed four million, find the sum of the even-valued terms.
 *
 */
public class E2 {
    public static void main(String[] args) {
        int fib_0 = 1;
        int fib_1 = 2;
        int fib_current = 3;
        int sum = 2;

        int i = 4;
        while (fib_current < 4000000) {
            if (fib_current % 2 == 0)
                sum += fib_current;
            fib_0 = fib_1;
            fib_1 = fib_current;
            fib_current = fib_0 + fib_1;
            i++;
        }

        System.out.println(sum);
    }
}
