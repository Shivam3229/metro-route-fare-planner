package com.shivam.metro.metroroutefareplanner.graph;

public class NodeDistance {
    private final String station;
    private final double distance;

    public NodeDistance(String station, double distance) {
        this.station = station;
        this.distance = distance;
    }

    public String getStation() {
        return station;
    }

    public double getDistance() {
        return distance;
    }
}
