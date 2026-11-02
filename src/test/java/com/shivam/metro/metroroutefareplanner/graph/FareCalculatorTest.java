package com.shivam.metro.metroroutefareplanner.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {

    @Test
    void shouldCalculateFare() {
        FareCalculator calculator = new FareCalculator();

        assertEquals(25.0, calculator.calculateFare(3.0), 0.001);
    }

    @Test
    void shouldCalculateBaseFareForZeroDistance() {
        FareCalculator calculator = new FareCalculator();

        assertEquals(10.0, calculator.calculateFare(0.0), 0.001);
    }

    @Test
    void shouldRejectNegativeDistance() {
        FareCalculator calculator = new FareCalculator();

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFare(-1.0)
        );
    }
}