package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyCalendar {

    static String[] days = new String[45];

    private static int findStartValue(String day) {
        int startDay = 0;
        switch (day) {
            case "Mon":
                startDay = 1;
                break;
            case "Tue":
                startDay = 2;
                break;
            case "Wed":
                startDay = 3;
                break;
            case "Thu":
                startDay = 4;
                break;
            case "Fri":
                startDay = 5;
                break;
            case "Sat":
                startDay = 6;
                break;
            case "Sun":
                startDay = 7;
                break;
        }
        return startDay;
    }

    public static void printMonth(int year, int month) {
        for (int i = 0; i < days.length; i++) {
            days[i] = " ";
        }

        int date = 1;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);

        int startValue = findStartValue(simpleDateFormat.format(calendar.getTime())) - 1;
        int endValue = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


        for (int w = startValue; w < days.length; w++) {
            if (date <= endValue) {
                days[w] = "" + date;
                date = date + 1;
            }
        }

    }

    private static void printDays() {
        String[] Days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (String day : Days) {
            System.out.print(day + " ");

        }

        System.out.print("\t\t");
        for (String day : Days) {
            System.out.print(day + " ");

        }
        System.out.print("\t\t");
        for (String day : Days) {
            System.out.print(day + " ");

        }
        System.out.println();
    }

    public static void viewCalendar(int year) {

        printDays();

        int row = 3;
        int columns = 4;
        int month = 1;
        for (int c = 1; c <= columns; c++) {

            int firstWeekValue = 0;
            int lastWeekValue = 6;

            for (int t = 1; t <= 6; t++) {

                if (c == 1) {
                    month = 1;
                }
                if (c == 2) {
                    month = 4;
                }
                if (c == 3) {
                    month = 7;
                }
                if (c == 4) {
                    month = 10;
                }


                for (int m = 1; m <= 3; m++) {

                    printMonth(year, month);

                    for (int i = firstWeekValue; i <= lastWeekValue; i++) {
                        System.out.printf("%s%2s%s", " ", days[i], " ");
                    }

                    if (m % row == 0) {
                        System.out.println();
                    } else {
                        System.out.print("\t\t");
                    }
                    month++;

                }

                firstWeekValue = firstWeekValue + 7;
                lastWeekValue = lastWeekValue + 7;

            }
            System.out.println();
           if (c!=4){
               printDays();
           }


        }


    }


}



