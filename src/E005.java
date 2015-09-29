/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #5
 *
 * 2520 is the smallest number that can be divided
 * by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly
 * divisible by all of the numbers from 1 to 20?
 *
 */

public class E005 {

    public static void main(String[] args) {
        int i = 20;
        boolean found = false;

        while (!found) {
            if(checkFactors(i)) {
                found = true;
                System.out.print(i);
            }

            // skip odds
            i += 2;
        }
    }

    public static boolean checkFactors(int n) {
        for (int i = 0; i < 20; i++)
            if (n % (i + 1) != 0)
                return false;

        return true;
    }

}
