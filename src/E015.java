/**
 * Created by jared on 9/30/15.
 *
 * Starting in the top left corner of a 2×2 grid,
 * nd only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 *    .______.______.
 *    |      |      |
 *    |      |      |
 *    |______|______|
 *    |      |      |
 *    |      |      |
 *    |______|______|
 *
 * How many such routes are there through a 20×20 grid?
 *
 */
public class E015 {

    public static void main(String[] args) {
        System.out.println(countRoutes(20));
    }

    private static long countRoutes(int length) {
        long[][] arr = new long[length + 1][length + 1];

        for (int i = 0; i < length; i++)
            arr[length][i] = 1;

        for (int i = 0; i < length; i++)
            arr[i][length] = 1;

        for(int i = length - 1; i >= 0; i--)
            for(int j = length - 1; j >= 0; j--)
                arr[i][j] = arr[i + 1][j] + arr[i][j + 1];

        return arr[0][0];
    }
}
