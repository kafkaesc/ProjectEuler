/**
 * Created by jared on 9/17/15.
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Expect this problem to be solved SLOWLY.
 *
 */

public class E10 {

    public static void main(String[] args) {
        long rollingSum = 2L;
        for (long i = 3L; i < 2000000L; i += 2) {
            if (checkPrimality(i)) {
                //System.out.println(i);
                rollingSum += i;
            }
        }
        System.out.println(rollingSum);
    }

    // returns whether or not the given number is prime
    // re-used form E3
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
