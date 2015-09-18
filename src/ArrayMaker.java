/**
 * Created by jared on 9/17/15.
 *
 * In Project Euler problem's I find myself repeatedly
 * hardcoding a number set into an array. Hopefully this
 * class will automate reading a text file and making an
 * array out of it.
 *
 * CURRENTLY: The ArrayMaker should produce a compilable
 * 2D array from a properly formatted file. Will work on
 * decomposition for 1D arrays.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMaker {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/ArrayMakerInput.txt");
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

        System.out.print(sb.toString());

    }

}
