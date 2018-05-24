package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Function {

    public static void findDayOfDate() {

        String[] alDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        Calendar calendar = Calendar.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        System.out.print("Enter month: ");
        int month = scanner.nextInt();

        System.out.print("Enter date: ");
        int date = scanner.nextInt();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, date);

        String day = simpleDateFormat.format(calendar.getTime());

        for (int i = 0; i < alDays.length; i++) {
            if (day.equals(alDays[i])) {
                System.out.println("The day is " + days[i]);
            }
        }


    }

    private static int findTotatNumberOfMoth(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int totalNumberOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return totalNumberOfMonth;


    }


    private static void printDays() {
        String[] Days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (String day : Days) {
            System.out.print(day + " ");

        }
    }

    private static int startingPoint(int year, int month) {

        int dateStartingNumber = 0;

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);

        String currentDay = simpleDateFormat.format(calendar.getTime());

        for (int i = 0; i < days.length; i++) {
            if (currentDay.equals(days[i])) {
                dateStartingNumber = i;
            }
        }


        return dateStartingNumber;
    }


    private static String getMonthName(int num) {
        String[] days = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        String day = days[num - 1];
        return day;
    }

    public static void viweCaleder(int year, int month) {

        int dateStart = startingPoint(year, month)+1;
        int dateEnd = findTotatNumberOfMoth(year, month);
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        // m,t,w,t,f,s,s - dates orders
        String[] cal = new String[35];
        int day = 1;

        for (int i = 0; i < cal.length; i++) {
            if (i >= dateStart && i <= dateEnd + dateStart +1) {

                cal[i] = "" + day;
                day = day + 1;
            } else {
                cal[i] = " ";
            }
        }


        System.out.println("\t" + year + "  OF  " + getMonthName(month));
        printDays();
        System.out.println();
        String space = "  ";
        String doubleSpace = "   ";

        for (int c = 0; c < cal.length; c++) {
            if (cal[c].length() == 1) {
                if (c % 7 == 0) {
                    System.out.print(cal[c] + doubleSpace);
                    System.out.println();
                } else {
                    System.out.print(cal[c] + doubleSpace);
                }
            } else {
                if (c % 7 == 0) {
                    System.out.print(cal[c] + space);
                    System.out.println();
                } else {
                    System.out.print(cal[c] + space);
                }
            }
        }

    }
}
