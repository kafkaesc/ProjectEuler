/**
 * Created by jared on 10/5/15.
 *
 * Project Euler, problem #21
 *
 * Let d(n) be defined as the sum of proper divisors of n
 * (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b
 * are an amicable pair and each of a and b are called
 * amicable numbers.
 *
 * For example, the proper divisors of 220 are
 * 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
 * therefore d(220) = 284. The proper divisors
 * of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 */

public class E021 {
    final static int CACHE_SIZE = 10001;
    private static int[] divisorSumCache;

    public static void main(String[] args) {
        setCache();
        System.out.println(amicableSum(10000));
    }

    private static int amicableSum(int n) {
        int sum = 0;
        boolean found[] = new boolean[n];
        for(int i = 0; i < found.length; i++)
            found[i] = false;

        for(int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(amicable(i, j) && !found[i]) {
                    found[i] = true;
                    sum += i;
                }
                if(amicable(i, j) && !found[j]) {
                    found[j] = true;
                    sum += j;
                }
            }
        }
        return sum;
    }

    private static boolean amicable(int a, int b) {
        int a_ds;
        int b_ds;

        if(divisorSumCache[a] != -1)
            a_ds = divisorSumCache[a];
        else
            a_ds = sumDivisors(a);

        if(divisorSumCache[b] != -1)
            b_ds = divisorSumCache[b];
        else
            b_ds = sumDivisors(b);

        if(a_ds == b && b_ds == a && a != b)
            return true;
        else
            return false;
    }

    private static int sumDivisors(int n) {
        if(n % 2 == 0)
            return sumDivisorsEvenHelper(n);
        else
            return sumDivisorsOddHelper(n);
    }

    private static int sumDivisorsOddHelper(int n) {
        if(n % 2 == 0)
            throw new IllegalArgumentException(
                    "sumDivisorsOddHelper is designed " +
                            "to work with odd arguments.");

        int sum = 1;
        for(int i = 3; i * i < n; i += 2) {
            if(n % i == 0 && i * i != n) {
                sum += i;
                sum += n / i;
            }
            if(n % i == 0 && i * i == n) {
                sum += i;
            }
        }
        divisorSumCache[n] = sum;
        return sum;
    }

    private static int sumDivisorsEvenHelper(int n) {
        int sum = 1;
        for(int i = 2; i * i < n; i++) {
            if(n % i == 0 && i * i != n) {
                sum += i;
                sum += n / i;
            }
            if(n % i == 0 && i * i == n) {
                sum += i;
            }
        }
        divisorSumCache[n] = sum;
        return sum;
    }

    private static void setCache() {
        divisorSumCache = new int[CACHE_SIZE];
        for(int i = 0; i < CACHE_SIZE; i++)
            divisorSumCache[i] = -1;
    }
}
