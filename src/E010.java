/**
 * Created by jared on 9/17/15.
 *
 * Project Euler, problem #10
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Note: Expect this solution to run SLOWLY.
 *
 */

public class E010 {

    public static void main(String[] args) {
        int primeList[] = SieveOfEratosthenes.findPrimes(2000000);
        long sum = 0;
        for(int i = 0; i < primeList.length; i++)
            sum += primeList[i];
        System.out.println(sum);
    }
}
