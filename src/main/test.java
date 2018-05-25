package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
    public static void main(String[] args) {

        String[] days = new String[42];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        Calendar calendar = Calendar.getInstance();
        int totalNumberOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = 0;
        String day = simpleDateFormat.format(calendar.getTime());


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

        for (int j = 0; j < days.length; j++) {
            days[j] = " ";
        }
        int date = 1;
        for (int i = 1; i <= totalNumberOfMonth; i++) {
            days[i + startDay] = "" + date;
            date++;
        }

        for (String da : days) {
            System.out.print(da);
        }

    }


}

