/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #3
 * What is the largest prime factor of the number 600851475143?
 *
 */

public class E3 {

    public static void main(String[] args) {
        long given = 600851475143L;
        long answer = findHighestPrimeFactor(given);

        System.out.println(answer);
    }

    static private long findHighestPrimeFactor(long n) {
        // reduce range to values capable of being factors
        long divisor = (long)Math.sqrt(n);

        while (divisor > 2) {
            if (n % divisor == 0 && checkPrimality(divisor)) {
                return divisor;
            }

            // skip evens
            if (divisor % 2 == 0) divisor--;
            else divisor -= 2;
        }
        return -1;
    }

    // returns whether or not the given number is prime
    static private boolean checkPrimality(long n) {
        // first, check if even
        if (n % 2 == 0)
            return false;

        // now, check against odd numbers
        for (int i = 3; i < n / 2; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

}
