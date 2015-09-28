/**
 * Created by jared on 9/28/15.
 *
 * Project Euler, problem #13
 *
 * Work out the first ten digits of the sum of
 * the one-hundred 50-digit numbers in E13input.txt.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;

public class E13 {

    private static String[] input;
    private static File E13input = new File("src/E13input.txt");;

    public static void main(String[] args) {
        try {
            loadInput();

            BigInteger answer = BigInteger.ZERO;
            BigInteger bi = BigInteger.ZERO;
            for(int i = 0; i < input.length; i++) {
                bi = new BigInteger(input[i]);
                answer = answer.add(bi);
            }
            BigInteger divisor = new BigInteger("1000000000000000000000000000000000000000000");
            answer = answer.divide(divisor);
            System.out.println(answer);

        } catch (FileNotFoundException fne) {
            System.out.println("Check the location of file E13input.txt");
        }
    }

    private static void loadInput() throws FileNotFoundException {
        input = ArrayMaker.string1D(E13input);
    }
}
