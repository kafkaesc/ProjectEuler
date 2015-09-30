/**
 * Created by jared on 9/30/15.
 *
 * Project Euler, problem #16
 *
 * 2^15 = 32768 and the sum of its digits is
 * 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 */

import java.math.BigInteger;

public class E016 {

    public static void main(String[] args) {
        String longNumber = makeNumericalString(2, 1000);
        int answer = sumDigits(longNumber);
        System.out.println(answer);
    }

    private static String makeNumericalString(int base, int power) {
        BigInteger n = BigInteger.valueOf(base);
        n = n.pow(power);
        return n.toString();
    }

    private static int sumDigits(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
            sum += s.charAt(i) - '0';
        return sum;
    }
}
