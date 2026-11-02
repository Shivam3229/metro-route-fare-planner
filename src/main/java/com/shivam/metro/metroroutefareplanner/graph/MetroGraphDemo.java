package com.shivam.metro.metroroutefareplanner.graph;

 public class MetroGraphDemo {

    public static void main(String[] args) {
        MetroGraph graph = new MetroGraph();

        graph.addWeightedConnection("Central", "Museum", 2.0);
        graph.addWeightedConnection("Central", "Park", 2.0);
        graph.addWeightedConnection("Museum", "Airport", 8.0);
        graph.addWeightedConnection("Park", "Airport", 1.0);

        graph.displayGraph();

        RouteResult result =
                graph.findShortestRouteDijkstra("Central", "Airport");

        System.out.println(result);


        System.out.println(
                graph.findShortestRouteDijkstra("Central", "Central")
        );

        System.out.println(
                graph.findShortestRouteDijkstra("Central", "Unknown")
        );

        graph.addStation("Harbor");

        System.out.println(
                graph.findShortestRouteDijkstra("Central", "Harbor")
        );

    }
}
