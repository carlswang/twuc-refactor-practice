package com.twu.refactoring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberCruncherTest {
    @Test
    public void should_Count_Even_Numbers() {
        int evens = new NumberCruncher(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).countEven();
        assertThat(evens, is(5));
    }

    @Test
    public void should_Count_Odd_Numbers() {
        int odds = new NumberCruncher(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).countOdd();
        assertThat(odds, is(6));
    }

    @Test
    public void should_Count_Positive_Numbers() {
        int positives = new NumberCruncher(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4).countPositive();
        assertThat(positives, is(5));
    }

    @Test
    public void should_Count_Negative_Numbers() {
        int negatives = new NumberCruncher(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4).countNegative();
        assertThat(negatives, is(5));
    }
}
