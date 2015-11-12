/**
 * Created by jared on 11/12/15.
 *
 * A basic java implementation of the Sieve of Eratosthenes for
 * finding primes.
 *
 */

import java.util.ArrayList;

public class SieveOfEratosthenes {

    // Returns an array containing all prime numbers beneath
    // the argument.
    public static int[] findPrimes(int upperBound) {
        boolean[] theSieve = new boolean[upperBound];
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < theSieve.length; i++)
            theSieve[i] = true;
        for (int i = 2; i < theSieve.length; i++) {
            if (theSieve[i]) {
                answer.add(i);
                for (int j = i; j < theSieve.length; j += i)
                    theSieve[j] = false;
            }
        }
        int ans[] = new int[answer.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = answer.get(i);
        return ans;
    }

    // Returns an array containing all the primes between the first argument
    // and the second. Note that because of the nature of the sieve there is
    // no improvement in performance, but the output might be more helpful for
    // some uses.
    public static int[] findPrimes(int lowerBound, int upperBound) {
        boolean[] theSieve = new boolean[upperBound];
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < theSieve.length; i++)
            theSieve[i] = true;
        for (int i = 2; i < theSieve.length; i++) {
            if(theSieve[i] && i > lowerBound)
                answer.add(i);
            if(theSieve[i])
                for (int j = i; j < theSieve.length; j += i)
                    theSieve[j] = false;
        }
        int ans[] = new int[answer.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = answer.get(i);
        return ans;
    }
}
