/**
 * Created by jared on 10/1/15.
 *
 * Project Euler, problem #17
 *
 * If the numbers 1 to 5 are written out in words:
 * one, two, three, four, five, then there are
 * 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand)
 * inclusive were written out in words, how many
 * letters would be used?
 *
 */
public class E017 {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1001; i++)
            sum += numberToProse(i).replaceAll("\\s", "").length();
        System.out.println(sum);

    }

    // Takes an int and returns a string representing the
    // int written out. Range so far is 0 - 9999
    private static String numberToProse(int n) {
        if(n == 0)
            return "zero";

        if(n < 10)
            return intToWord(n);

        StringBuilder sb = new StringBuilder();

        // check the tens place
        if(n % 100 < 10)
            sb.insert(0, intToWord(n % 10));
        else if(n % 100 < 20)
            sb.insert(0, teenWord(n % 100));
        else
            sb.insert(0, tensPlaceWord((n % 100) / 10) + " " + intToWord(n % 10));

        n /= 100;

        // add the hundred place
        if(n > 0 && sb.length() != 0)
            sb.insert(0, intToWord(n % 10) + " hundred and ");
        else if (n > 0)
            sb.insert(0, intToWord(n % 10) + " hundred ");

        if(sb.toString().equals(" hundred "))
            sb = new StringBuilder("");

        n /= 10;

        // the thousand spot
        if(n > 0)
            sb.insert(0, intToWord(n) + " thousand ");

        return sb.toString();
    }

    // Give the word related to a single digit.
    private static String intToWord(int n) {
        if(n < 0 || n > 9)
            throw new IllegalArgumentException("Number should be between 0-9");

        switch(n) {
            case 0: return "";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return null;
        }
    }

    // Returns the right word for those pesky, 11, 12, and teens
    private static String teenWord(int n) {
        if(n < 10 || n > 19)
            throw new IllegalArgumentException("Number should be between 0-9");

        switch(n) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return null;
        }
    }

    // Returns the associated word for digits in the tens place
    private static String tensPlaceWord(int n) {
        if(n < 2 || n > 9)
            throw new IllegalArgumentException("Number should be between 0-9");

        switch(n) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return null;
        }
    }
}
