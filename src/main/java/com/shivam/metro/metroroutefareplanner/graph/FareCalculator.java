package com.shivam.metro.metroroutefareplanner.graph;

public class FareCalculator {

    private static final double BASE_FARE = 10.0;
    private static final double FARE_PER_KM = 5.0;

    public double calculateFare(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(
                    "Distance cannot be negative"
            );
        }

        return BASE_FARE + (distance * FARE_PER_KM);
    }
}