/**
 * Created by Jared Hettinger on 9/17/15.
 *
 * This class has several functions designed to take
 * a text file and output a usable array for other Java
 * classes.
 *
 * int1D will return a one-dimensional array of the ints in the file
 *
 * int2D will return a two-dimensional array of the ints in the file
 *
 * string2D will return a String formatted so that it can be copy
 * and pasted into your Java code and compile, if case you're looking
 * to hardcode the data
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMaker {

    public static int[] int1D(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        ArrayList<Integer> arr = new ArrayList<Integer> ();

        while(sc.hasNextInt())
            arr.add(sc.nextInt());
        sc.close();

        int[] output = new int[arr.size()];
        for (int i = 0; i < output.length; i++)
            output[i] = arr.get(i);
        return output;
    }

    public static int[][] int2D(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);

        // first pass to find the dimensions for the array, i x j
        int iCount = 0;
        int jCount = 0;
        while (sc.hasNext()) {
            Scanner sc2 = new Scanner(sc.nextLine());
            int tempj = 0;
            while (sc2.hasNextInt()) {
                tempj++;
                if (tempj > jCount)
                    jCount = tempj;
                sc2.nextInt();
            }
            sc2.close();
            iCount++;
        }
        sc.close();
        int[][] output = new int[iCount][jCount];

        // second pass is to load ints into the array
        sc = new Scanner(f);
        for (int i = 0; i < iCount; i++) {
            for (int j = 0; j < jCount; j++) {
                output[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return output;
    }

    public static String string2D(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        Scanner sc2;
        StringBuilder sb = new StringBuilder();

        sb.append("{ ");
        while (sc.hasNext()) {
            sc2 = new Scanner(sc.nextLine());
            sb.append("{ ");
            while (sc2.hasNext())
                sb.append(sc2.nextInt() + ", ");
            sb.delete(sb.length() - 2, sb.length());
            sb.append(" },\n");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" };");

        sc.close();

        return sb.toString();
    }
}
