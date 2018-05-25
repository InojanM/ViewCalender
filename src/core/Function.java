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

    private static int findTotalNumberOfMoth(int year, int month) {

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
        return days[num - 1];
    }

    public static void viewCalender(int year, int month) {

        int dateStart = startingPoint(year, month);
        int dateEnd = findTotalNumberOfMoth(year, month);
        // m,t,w,t,f,s,s - dates orders
        String[] cal = new String[40];
        int day = 1;
        for (int i = 0; i < cal.length; i++) {
            cal[i] = " ";
        }

        for (int j = 1; j <= dateEnd; j++) {  // 4 , 28 , 1
            cal[j + dateStart] = "" + day;
            day++;
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


    public static int numberValidate(String promt) {
        String msg = "Enter " + promt;
        boolean validate = true;
        int num = 0;
        while (validate) {

            Scanner in = new Scanner(System.in);
            System.out.print(msg);
            String number = in.next();
            validate = false;
            try {
                num = Integer.parseInt(number);
            } catch (Exception e) {
                validate = true;
                msg = "Invalid " + promt + "! plz enter the valid " + promt + " : ";
            }
        }
        return num;
    }

    public static void calendar() {

        boolean test = true;
        while (test) {

            int year = numberValidate("year: ");
            int month = numberValidate("month: ");

            if (year > 0) {
                if (month > 0 && month < 13) {
                    viewCalender(year, month);
                    test = false;

                } else {
                    System.out.println("month should be more than 0 and less than 13");
                }
            } else {
                System.out.println("year should be more than 0");


            }
        }

    }


}
