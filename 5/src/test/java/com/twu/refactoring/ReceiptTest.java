package com.twu.refactoring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class ReceiptTest {

    @Test
    public void should_Calculate_Charges_For_AC_Taxi_For_30Kms() {
        double cost = new Receipt(new Taxi(true, 30, false)).getTotalCost();
        assertThat(cost, closeTo(649D, 0.01D));
    }

    @Test
    public void should_Calculate_Charges_For_Non_AC_Taxi_For_30Kms() {
        double cost = new Receipt(new Taxi(false, 30, false)).getTotalCost();
        assertThat(cost, closeTo(484D, 0.01D));
    }

    @Test
    public void should_Calculate_For_AC_Charges_For_30Kms_Peak_Time() {
        double cost = new Receipt(new Taxi(true, 30, true)).getTotalCost();
        assertThat(cost, closeTo(767.8D, 0.01D));

    }

    @Test
    public void should_Calculate_Charges_For_Non_AC_Taxi_For_30Kms_Peak_Time() {
        double cost = new Receipt(new Taxi(false, 30, true)).getTotalCost();
        assertThat(cost, closeTo(569.8D, 0.01D));
    }
}
