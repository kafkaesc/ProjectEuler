/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #4
 *
 * A palindromic number reads the same both ways. The largest
 * palindrome made from the product of two 2-digit numbers is
 * 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */

public class E4 {

    public static void main(String[] args) {
        // Factors not necessary for Project Euler, but I was curious.
        int factor_1 = 0;
        int factor_2 = 0;
        int largestPalindrome = 0;

        // A nested loop, gross!
        // But the loops are constant, so the Big O is still O(1).
        for(int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                int temp = i * j;
                if(isPalindrome(temp) && temp > largestPalindrome) {
                    factor_1 = i;
                    factor_2 = j;
                    largestPalindrome = temp;
                }
            }
        }

        System.out.println(factor_1 + " * " + factor_2 + " = " + largestPalindrome);
    }

    private static boolean isPalindrome(int n) {
        StringBuilder r = new StringBuilder();
        r.append(Integer.toString(n));
        r.reverse();
        int reverse = Integer.parseInt(r.toString());

        if (reverse == n) return true;
        else return false;
    }
}
