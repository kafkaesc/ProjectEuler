/**
 * Created by jared on 10/5/15.
 *
 * A perfect number is a number for which the sum of its
 * proper divisors is exactly equal to the number. For example,
 * the sum of the proper divisors of 28 would be
 * 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors
 * is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 * the smallest number that can be written as the sum of two
 * abundant numbers is 24. By mathematical analysis, it can be shown
 * that all integers greater than 28123 can be written as the sum of
 * two abundant numbers. However, this upper limit cannot be reduced
 * any further by analysis even though it is known that the greatest
 * number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written
 * as the sum of two abundant numbers.
 *
 */

public class E023 {

    private static final int LIMIT = 28123;
    private static boolean[] abundantCache = new boolean[LIMIT + 1];
    private static boolean[] abundantSumsCache = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        loadAbundantCache();
        loadAbundantSumsCache();

        int sum = 0;
        for(int i = 0; i < LIMIT; i++)
            if(!abundantSumsCache[i])
                sum += i;

        System.out.println(sum);
    }

    private static void loadAbundantCache() {
        for(int i = 1; i <= LIMIT; i++)
            sumDivisors(i);
    }

    private static void loadAbundantSumsCache() {
        System.out.println();
        for(int i = 1; i < abundantCache.length; i++)
            for(int j = i; j <= abundantCache.length; j++)
                if (i + j < LIMIT && abundantCache[i] && abundantCache[j])
                    abundantSumsCache[i + j] = true;
    }

    // reworked from E021.java
    private static int sumDivisors(int n) {
        int sum = 1;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0 && i * i != n) {
                sum += i;
                sum += n / i;
            }
            if (i * i == n) {
                sum += i;
            }
        }

        if(sum > n)
            abundantCache[n] = true;

        return sum;
    }
}
