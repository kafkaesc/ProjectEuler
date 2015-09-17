/**
 * Created by jared on 9/16/15.
 *
 * Project Euler, problem #6
 *
 * The difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 *
 */
public class E6 {

    public static void main(String[] args) {
        int answer = squareOfSums(100) - sumOfSquares(100);
        System.out.println(answer);
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (int)Math.pow(i + 1, 2);
        }
        return sum;
    }

    private static int squareOfSums(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += i + 1;

        return (int) Math.pow(sum, 2);
    }

}
