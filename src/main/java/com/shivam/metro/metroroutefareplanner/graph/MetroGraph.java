package com.shivam.metro.metroroutefareplanner.graph;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;

public class MetroGraph {

    private final Map<String, List<Edge>> adjacencyList =
            new LinkedHashMap<>();

    public void addStation(String station) {
        adjacencyList.putIfAbsent(station, new ArrayList<>());
    }

    public void addWeightedConnection(
            String station1, String station2, double distance) {

        if (distance < 0) {
            throw new IllegalArgumentException(
                    "Distance cannot be negative"
            );
        }

        addStation(station1);
        addStation(station2);

        addEdgeIfAbsent(station1, station2, distance);
        addEdgeIfAbsent(station2, station1, distance);
    }

    private void addEdgeIfAbsent(
            String source, String destination, double distance) {

        boolean exists = adjacencyList.get(source).stream()
                .anyMatch(edge ->
                        edge.getDestination().equals(destination));

        if (!exists) {
            adjacencyList.get(source)
                    .add(new Edge(destination, distance));
        }
    }

    public void displayGraph() {
        for (Map.Entry<String, List<Edge>> entry
                : adjacencyList.entrySet()) {

            System.out.print(entry.getKey() + " -> ");

            for (Edge edge : entry.getValue()) {
                System.out.print(
                        edge.getDestination() + "("
                                + edge.getDistance() + " km) "
                );
            }

            System.out.println();
        }
    }

    public RouteResult findShortestRouteDijkstra(
            String source, String destination) {

        if (!adjacencyList.containsKey(source)
                || !adjacencyList.containsKey(destination)) {
            return new RouteResult(List.of(), -1);
        }

        Map<String, Double> distances = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String station : adjacencyList.keySet()) {
            distances.put(station, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);

        PriorityQueue<NodeDistance> queue = new PriorityQueue<>(
                Comparator.comparingDouble(NodeDistance::getDistance)
        );

        queue.offer(new NodeDistance(source, 0.0));

        while (!queue.isEmpty()) {
            NodeDistance current = queue.poll();

            String station = current.getStation();
            double currentDistance = current.getDistance();

            // Skip outdated entries
            if (currentDistance > distances.get(station)) {
                continue;
            }

            if (station.equals(destination)) {
                break;
            }

            for (Edge edge : adjacencyList.get(station)) {
                String neighbor = edge.getDestination();

                double newDistance =
                        currentDistance + edge.getDistance();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    parent.put(neighbor, station);

                    queue.offer(
                            new NodeDistance(neighbor, newDistance)
                    );
                }
            }
        }

        if (distances.get(destination) == Double.POSITIVE_INFINITY) {
            return new RouteResult(List.of(), -1);
        }

        List<String> route = new ArrayList<>();
        String current = destination;

        while (current != null) {
            route.add(current);
            current = parent.get(current);
        }

        Collections.reverse(route);

        return new RouteResult(route, distances.get(destination));
    }



}