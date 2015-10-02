/**
 * Created by jared on 10/2/15.
 */

import java.io.File;
import java.io.FileNotFoundException;

public class E067 {

    private static File E067input = new File("src/E067input.txt");

    public static void main(String[] args) {
        try {
            int[][] triangle = ArrayMaker.int2D(E067input);
            System.out.println(E018.findLongestPath(triangle));
        }
        catch(FileNotFoundException fne) {
            System.out.println("Could not find file E018input.txt");
        }

    }

}
