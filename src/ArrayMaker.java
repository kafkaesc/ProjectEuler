/**
 * Created by Jared Hettinger on 9/17/15.
 *
 * This class has several functions designed to take
 * a text file and output a usable array for other Java
 * classes.
 *
 * This class was inspired by the frequent need to use
 * plaintext numerical data in puzzles from
 * Project Euler. (projecteuler.net)
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMaker {

    // Returns a one-dimensional array of the ints in the text file.
    public static int[] int1D(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        ArrayList<Integer> al = new ArrayList<Integer> ();

        while(sc.hasNextInt())
            al.add(sc.nextInt());
        sc.close();

        int[] output = new int[al.size()];
        for (int i = 0; i < output.length; i++)
            output[i] = al.get(i);
        return output;
    }

    // Returns a two-dimensional array of the ints in a text file.
    // Lines will be counted to calculate the amount of rows. The amount of
    // ints on each line will be counted on each line will be counted. The
    // largest count of ints will be used to set columns. The function SHOULD
    // work for jagged arrays.
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
            int j = 0;
            Scanner sc2 = new Scanner(sc.nextLine());
            while (sc2.hasNext()) {
                output[i][j] = sc2.nextInt();
                j++;
            }
        }
        sc.close();
        return output;
    }

    public static String int1DHardcode(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        StringBuilder sb = new StringBuilder();

        sb.append("{ ");
        while(sc.hasNext())
            sb.append(sc.next() + ", ");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");

        return sb.toString();
    }

    // Returns a String that can be copy and pasted into your code in
    // order to hardcode the data into a class. Each line will be
    // interpreted as a new row.
    public static String int2DHardcode(File f) throws FileNotFoundException {
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

    // Returns a one-dimensional array of Strings from the text file.
    // Standard delimiters are used by the Scanner object.
    public static String[] string1D(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        ArrayList<String> al = new ArrayList<String> ();

        while(sc.hasNext())
            al.add(sc.next());
        sc.close();

        String[] output = new String[al.size()];
        for(int i = 0; i < al.size(); i++)
            output[i] = al.get(i);
        return output;
    }

    // Returns a String that can be copy and pasted into your code in
    // order to hardcode the data into a class.
    public static String string1DHardcode(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        StringBuilder sb = new StringBuilder();

        sb.append("{ \"");
        while(sc.hasNext())
            sb.append(sc.next() + "\", \"");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");

        return sb.toString();
    }
}
