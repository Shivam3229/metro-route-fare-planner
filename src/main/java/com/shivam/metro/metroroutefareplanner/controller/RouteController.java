
package com.shivam.metro.metroroutefareplanner.controller;

import com.shivam.metro.metroroutefareplanner.graph.FareCalculator;
import com.shivam.metro.metroroutefareplanner.graph.MetroGraph;
import com.shivam.metro.metroroutefareplanner.graph.RouteResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final MetroGraph metroGraph;
    private final FareCalculator fareCalculator;

    public RouteController(
            MetroGraph metroGraph,
            FareCalculator fareCalculator) {
        this.metroGraph = metroGraph;
        this.fareCalculator = fareCalculator;
    }

    @GetMapping
    public Map<String, Object> findRoute(
            @RequestParam String source,
            @RequestParam String destination) {

        RouteResult result =
                metroGraph.findShortestRouteDijkstra(source, destination);

        if (result.getRoute().isEmpty()) {
            return Map.of(
                    "source", source,
                    "destination", destination,
                    "message", "No route found"
            );
        }

        double fare = fareCalculator.calculateFare(
                result.getTotalDistance()
        );

        return Map.of(
                "source", source,
                "destination", destination,
                "route", result.getRoute(),
                "distanceKm", result.getTotalDistance(),
                "fare", fare
        );
    }
}
