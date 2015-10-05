/**
 *
 * Created by jared on 10/5/15.
 *
 * Project Euler, problem #20
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is
 * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 */

import java.math.BigInteger;

public class E020 {

    public static void main(String[] args) {
        final BigInteger ONE_HUNDRED = new BigInteger("100");
        BigInteger hundredFactorial = bigIntegerFactorial(ONE_HUNDRED);
        System.out.println(sumIntString(hundredFactorial.toString()));
    }

    private static BigInteger bigIntegerFactorial(BigInteger n) {
        BigInteger TWO = new BigInteger("2");

        BigInteger output = new BigInteger("1");
        while (!n.equals(BigInteger.ONE)) {
            output = output.multiply(n) ;
            n = n.subtract(BigInteger.ONE);
        }
        return output;
    }

    private static int sumIntString(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
            sum += s.charAt(i) - '0';
        return sum;
    }
}
