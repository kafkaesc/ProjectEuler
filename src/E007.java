/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #7
 *
 * By listing the first six prime numbers:
 *     2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 *
 */

public class E007 {

    // Optimizing is perhaps unnecessary for a puzzle, but who's afraid of a cache?
    // Primes from https://primes.utm.edu/lists/small/1000.txt,
    // but were checked independently.
    static int[] primeCache =
            { 2,   3,   5,   7,  11,  13,  17,  19,  23,  29,
                     31,  37,  41,  43,  47,  53,  59,  61,  67,  71,
                     73,  79,  83,  89,  97, 101, 103, 107, 109, 113,
                    127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                    179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
                    233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                    283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
                    353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
                    419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
                    467, 479, 487, 491, 499, 503, 509, 521, 523, 541 };

    public static void main(String[] args) {
        System.out.println(findPrime(10001));
    }

    private static int findPrime(int n) {
        if(n - 1 < primeCache.length)
            return primeCache[n - 1];

        int primeIndex = primeCache.length;
        int temp = primeCache[primeCache.length -1] + 2;
        while (primeIndex != n) {

            if(checkPrimality(temp))
                primeIndex++;

            if (primeIndex == n)
                return temp;

            // skip evens
            temp += 2;
        }
        return -1;
    }

    // returns whether or not the given number is prime
    // re-used form E003
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
