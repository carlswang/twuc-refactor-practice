package com.twu.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @BeforeEach
    public void setUp() {
        north = new Direction('N');
        east = new Direction('E');
    }

    @Test
    public void should_Turn_East_When_Turn_Right_From_North() {
        Direction east = north.turnRight();
        Assertions.assertEquals('E', east.getDirection());
    }

    @Test
    public void should_Turn_West_When_Turn_Left_From_North() {
        Direction west = north.turnLeft();
        Assertions.assertEquals('W', west.getDirection());
    }

    @Test
    public void should_Turn_North_When_Turn_Left_From_East() {
        Direction north = east.turnLeft();
        Assertions.assertEquals('N', north.getDirection());
    }
}
