/**
 * Created by jared on 10/5/15.
 *
 * Project Euler, problem #22
 *
 * Using E022input.txt, a 46K text file containing over five-thousand
 * first names, begin by sorting it into alphabetical order. Then
 * working out the alphabetical value for each name, multiply this
 * value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name
 * in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class E022 {

    private static String[] names;

    public static void main(String[] args) {
        try {
            loadNames();
            Arrays.sort(names);

            int ongoingTotal = 0;
            for(int i = 0; i < names.length; i++)
                ongoingTotal += nameTotal(names[i]) * (i + 1);
            System.out.println(ongoingTotal);
        }
        catch (FileNotFoundException fne) {
            System.out.println("Check for file E022input.txt");
        }
    }

    private static int nameTotal(String s) {
        int output = 0;
        for(int i = 0; i < s.length(); i++)
            output += s.charAt(i) - 'A' + 1;
        return output;
    }

    private static void loadNames() throws FileNotFoundException{
        File f = new File("src/E022input.txt");
        names = ArrayMaker.string1D(f);
    }

}
