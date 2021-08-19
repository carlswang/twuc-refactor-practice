package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;

    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;
        year = getTime(0, 4, "Year string is less than 4 characters", "Year is not an integer", 2000, 2012, "Year cannot be less than 2000 or more than 2012");
        month = getTime(5, 7, "Month string is less than 2 characters", "Month is not an integer", 1, 12, "Month cannot be less than 1 or more than 12");
        date = getTime(8, 10, "Date string is less than 2 characters", "Date is not an integer", 1, 31, "Date cannot be less than 1 or more than 31");
        if (dateAndTimeString.charAt(11) == 'Z') {
            hour = 0;
            minute = 0;
        } else {
            hour = getTime(11, 13, "Hour string is less than 2 characters", "Hour is not an integer", 0, 23, "Hour cannot be less than 0 or more than 23");
            minute = getTime(14, 16, "Minute string is less than 2 characters", "Minute is not an integer", 0, 59, "Minute cannot be less than 0 or more than 59");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getTime(int minLength, int maxLength, String judgeLengthMessage, String judgeInteger, int minTime, int maxTime, String judgeTime) {
        int year;
        try {
            String yearString = dateAndTimeString.substring(minLength, maxLength);
            year = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(judgeLengthMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(judgeInteger);
        }
        if (year < minTime || year > maxTime)
            throw new IllegalArgumentException(judgeTime);
        return year;
    }
}
