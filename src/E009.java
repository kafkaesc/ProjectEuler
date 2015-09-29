/**
 * Created by jared on 9/17/15.
 *
 * Project Euler, problem #9
 *
 * A Pythagorean triplet is a set of three natural numbers,
 * a < b < c, for which, a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet
 * for which a + b + c = 1000.
 *
 * Find the product abc.
 *
 */
public class E009 {

    // For arrays size 3: [0] => a; [1] => b; [2] => c

    public static void main(String[] args) {
        int[] tri = new int[3];
        int m = 2;
        int n = 1;
        boolean found = false;

        for (n = 1; n < 500 && !found; n++) {
            for (m = n + 1; m < 500 && !found; m++) {
                tri = generateTriplet(m, n);
                if (sumTriplet(tri[0], tri[1], tri[2]) == 1000)
                    found = true;
            }
        }
        System.out.println(multiplyTriplet(tri[0], tri[1], tri[2]));
    }

    private static int multiplyTriplet(Integer... args) {
        int product = 1;
        for (int i : args)
            product *= i;
        return product;
    }

    private static int sumTriplet(Integer... args) {
        int sum = 0;
        for (int i : args)
            sum += i;
        return sum;
    }

    // Note: Using Euclid's Formula to generate Pythagorean triplets.
    // https://en.wikipedia.org/wiki/Pythagorean_triple
    private static int[] generateTriplet(int m, int n) {
        int[] ans = new int[3];
        ans[0] = (int)(Math.pow(m, 2) - Math.pow(n, 2));
        ans[1] = 2 * m * n;
        ans[2] = (int)(Math.pow(m, 2) + Math.pow(n, 2));
        return ans;
    }

}
