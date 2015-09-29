/**
 * Created by jared on 9/28/15.
 *
 * The following iterative sequence is
 * defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13,
 * we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 */

public class E014 {
    private static final int CACHE_SIZE = 4096;
    private static int[] cache = new int[CACHE_SIZE];

    public static void main(String[] args) {
        resetCache();

        int maxCount = 0;
        int initialNumber = 0;
        for(int i = 1; i < 1000000; i++) {
            int temp = collatz(i);
            if (maxCount < temp) {
                maxCount = temp;
                initialNumber = i;
            }
        }
        System.out.println(initialNumber);
    }

    // Returns the number of terms in the Collatz sequence,
    // inclusive of n and the terminating 1.
    private static int collatz(int n) {
        if(n < 1)
            return -1;

        // if the argument's solution is saved in the cache
        if(n <= CACHE_SIZE && cache[n - 1] != 0)
            return cache[n - 1];

        int count = 1;
        int cacheSpot = n - 1;
        long x = n;
        while(x != 1) {
            // if possible: use the cache OR fill it
            if(x < CACHE_SIZE && cache[(int)x - 1] != 0) {
                if (cacheSpot < CACHE_SIZE)
                    cache[cacheSpot] = count + cache[(int)x - 1] - 1;
                return count + cache[(int)x - 1] - 1;
            }
            // main collatz logic
            if(x % 2 == 0)
                x = x / 2;
            else
                x = 3 * x + 1;
            count++;
        }

        // if the solution can go into the cache, load it
        if(cacheSpot < CACHE_SIZE)
            cache[cacheSpot] = count;

        return count;
    }

    // This function may be a testament to my paranoia.
    // You can never be too safe!
    public static void resetCache() {
        for(int i = 0; i < CACHE_SIZE; i++)
            cache[i] = 0;
    }
}
