package com.shivam.metro.metroroutefareplanner.graph;

public class Edge {

    private final String destination;
    private final double distance;

    public Edge(String destination, double distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }
}
