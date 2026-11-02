package com.shivam.metro.metroroutefareplanner.graph;

import java.util.List;

public class RouteResult {

    private final List<String> route;
    private final double totalDistance;

    public RouteResult(List<String> route, double totalDistance) {
        this.route = List.copyOf(route);
        this.totalDistance = totalDistance;
    }

    public List<String> getRoute() {
        return route;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    @Override
    public String toString() {
        return "Route: " + route
                + ", Total distance: " + totalDistance + " km";
    }
}
