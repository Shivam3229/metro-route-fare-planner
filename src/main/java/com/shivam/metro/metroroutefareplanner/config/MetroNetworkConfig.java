
package com.shivam.metro.metroroutefareplanner.config;

import com.shivam.metro.metroroutefareplanner.graph.FareCalculator;
import com.shivam.metro.metroroutefareplanner.graph.MetroGraph;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetroNetworkConfig {

    @Bean
    public MetroGraph metroGraph() {
        MetroGraph graph = new MetroGraph();

        graph.addWeightedConnection("Central", "Museum", 2.0);
        graph.addWeightedConnection("Central", "Park", 2.0);
        graph.addWeightedConnection("Museum", "Airport", 8.0);
        graph.addWeightedConnection("Park", "Airport", 1.0);
        graph.addStation("Harbor");

        return graph;
    }
    @Bean
    public FareCalculator fareCalculator() {
        return new FareCalculator();
    }
}
