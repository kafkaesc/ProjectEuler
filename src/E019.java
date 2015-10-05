/**
 * Created by jared on 10/2/15.
 *
 * You are given the following information, but
 * you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4,
 * but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month
 * during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */

public class E019 {

    public static void main(String[] args) {

        int sundayCount = 0;
        int[] temp = {3, 1, 1, 1901};
        while (temp[3] != 2001) {
            temp = nextDay(temp);
            if(temp[0] == 1 && temp[1] == 1)
                sundayCount++;         // dancing through sunday
        }
        System.out.println(sundayCount);
    }

    // For int[i]: int[0] => day of week (Sun/Mon/Tue) range: 1-7
    //             int[1] => day of month (1 Sep.)     range: varies with month
    //             int[2] => month                     range: 1-12
    //             int[3] => year                      range: infinite?
    private static int[] nextDay(int[] day) {
        int[] nextDay = new int[4];
        nextDay[0] = (day[0] % 7) + 1;
        nextDay[1] = day[1] + 1;
        nextDay[2] = day[2];
        nextDay[3] = day[3];

        // thirty-day months
        if(thirtyDayMonth(nextDay[2]) && nextDay[1] == 31) {
            nextDay[1] = 1;
            nextDay[2] = incrementMonth(nextDay[2]);
        }

        // thirty-one day months
        if(thirtyOneDayMonth(nextDay[2]) && nextDay[1] == 32) {
            nextDay[1] = 1;
            nextDay[2] = incrementMonth(nextDay[2]);
        }

        // Damn you, February.
        if(day[2] == 2 && !leapYear(day[3]) && nextDay[1] == 29) {
            nextDay[1] = 1;
            nextDay[2] = incrementMonth(nextDay[2]);
        }
        if(day[2] == 2 && leapYear(day[3]) && nextDay[1] == 30) {
            nextDay[1] = 1;
            nextDay[2] = incrementMonth(nextDay[2]);
        }

        if(nextDay[1] == 1 && nextDay[2] == 1)
            nextDay[3]++;
        return nextDay;
    }

    private static int incrementMonth(int month) {
        return (month % 12) + 1;
    }

    private static boolean leapYear(int n) {
        if((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0))
            return true;
        else
            return false;
    }

    private static boolean thirtyDayMonth(int n) {
        switch (n) {
            case 4:
            case 6:
            case 9:
            case 11: return true;
            default: return false;
        }
    }

    private static boolean thirtyOneDayMonth(int n) {
        if(!thirtyDayMonth(n) && n != 2)
            return true;
        else
            return false;
    }

    private static String weekdayString(int n) {
        switch(n) {
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            default: return null;
        }
    }

    private static String monthString(int n) {
        switch(n) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return null;
        }
    }

    private static String dateToString(int[] day) {
        return weekdayString(day[0]) + " " +
                monthString(day[2]) + " " +
                day[1] + " " + day[3];
    }
}
