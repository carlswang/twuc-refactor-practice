package com.twu.refactoring;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class DateParserTest {
    @Test
    public void should_Throw_Exception_If_Year_String_Cannot_Be_Parsed() {
        try {
            new DateParser("111").parse();
            fail("Should have failed since the year string is less than 4 characters");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Year string is less than 4 characters"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Year_Is_Not_Integer() {
        try {
            new DateParser("abcd").parse();
            fail("Should have failed since the year string is not an integer");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Year is not an integer"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Year_Is_Less_Than_2000() {
        try {
            new DateParser("1999").parse();
            fail("Should have failed since the year is less than 2000");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Year cannot be less than 2000 or more than 2012"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Month_String_Cannot_Be_Parsed() {
        try {
            new DateParser("2012-1").parse();
            fail("Should have failed since the month string is less than 2 characters");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Month string is less than 2 characters"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Month_Is_Not_Integer() {
        try {
            new DateParser("2012-ab").parse();
            fail("Should have failed since the month string is not an integer");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Month is not an integer"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Month_Is_More_Than_12() {
        try {
            new DateParser("2012-13").parse();
            fail("Should have failed since the month is more than 12");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Month cannot be less than 1 or more than 12"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Date_String_Cannot_Be_Parsed() {
        try {
            new DateParser("2012-12-1").parse();
            fail("Should have failed since the date string is less than 2 characters");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Date string is less than 2 characters"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Date_Is_Not_Integer() {
        try {
            new DateParser("2012-12-ab").parse();
            fail("Should have failed since the date string is not an integer");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Date is not an integer"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Date_Is_More_Than_31() {
        try {
            new DateParser("2012-12-32").parse();
            fail("Should have failed since the date is more than 31");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Date cannot be less than 1 or more than 31"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Hour_String_Cannot_Be_Parsed() {
        try {
            new DateParser("2012-12-11T0").parse();
            fail("Should have failed since the hour string is less than 2 characters");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Hour string is less than 2 characters"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Hour_Is_Not_Integer() {
        try {
            new DateParser("2012-12-30Tab").parse();
            fail("Should have failed since the hour string is not an integer");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Hour is not an integer"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Hour_Is_More_Than_23() {
        try {
            new DateParser("2012-12-31T24").parse();
            fail("Should have failed since the hour is more than 23");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Hour cannot be less than 0 or more than 23"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Minute_String_Cannot_Be_Parsed() {
        try {
            new DateParser("2012-12-11T01:1").parse();
            fail("Should have failed since the minute string is less than 2 characters");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Minute string is less than 2 characters"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Minute_Is_Not_Integer() {
        try {
            new DateParser("2012-12-30T01:ab").parse();
            fail("Should have failed since the minute string is not an integer");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Minute is not an integer"));
        }
    }

    @Test
    public void should_Throw_Exception_If_Minute_Is_More_Than_59() {
        try {
            new DateParser("2012-12-31T23:60").parse();
            fail("Should have failed since the minute is more than 59");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Minute cannot be less than 0 or more than 59"));
        }
    }

    @Test
    public void should_Parse_Date_For_Valid_Input() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2012, Calendar.DECEMBER, 31, 23, 59, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();

        Date result = new DateParser("2012-12-31T23:59Z").parse();

        assertThat(result, is(expectedDate));
    }
}
