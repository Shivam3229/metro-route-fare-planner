package com.shivam.metro.metroroutefareplanner.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetroGraphTest {

    private MetroGraph graph;

    @BeforeEach
    void setUp() {
        graph = new MetroGraph();

        graph.addWeightedConnection("Central", "Museum", 2.0);
        graph.addWeightedConnection("Central", "Park", 2.0);
        graph.addWeightedConnection("Museum", "Airport", 8.0);
        graph.addWeightedConnection("Park", "Airport", 1.0);

        graph.addStation("Harbor");
    }

    @Test
    void shouldFindShortestRoute() {
        RouteResult result =
                graph.findShortestRouteDijkstra("Central", "Airport");

        assertEquals(
                java.util.List.of("Central", "Park", "Airport"),
                result.getRoute()
        );
        assertEquals(3.0, result.getTotalDistance(), 0.001);
    }

    @Test
    void shouldReturnZeroDistanceForSameStation() {
        RouteResult result =
                graph.findShortestRouteDijkstra("Central", "Central");

        assertEquals(java.util.List.of("Central"), result.getRoute());
        assertEquals(0.0, result.getTotalDistance(), 0.001);
    }

    @Test
    void shouldHandleUnknownStation() {
        RouteResult result =
                graph.findShortestRouteDijkstra("Central", "Unknown");

        assertTrue(result.getRoute().isEmpty());
        assertEquals(-1.0, result.getTotalDistance(), 0.001);
    }

    @Test
    void shouldHandleDisconnectedStation() {
        RouteResult result =
                graph.findShortestRouteDijkstra("Central", "Harbor");

        assertTrue(result.getRoute().isEmpty());
        assertEquals(-1.0, result.getTotalDistance(), 0.001);
    }
}
