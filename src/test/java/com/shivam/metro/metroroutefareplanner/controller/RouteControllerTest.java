
package com.shivam.metro.metroroutefareplanner.controller;

import com.shivam.metro.metroroutefareplanner.config.MetroNetworkConfig;
import com.shivam.metro.metroroutefareplanner.graph.FareCalculator;
import com.shivam.metro.metroroutefareplanner.graph.MetroGraph;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RouteController.class)
@Import({MetroNetworkConfig.class, FareCalculator.class})
class RouteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnShortestRouteAndFare() throws Exception {
        mockMvc.perform(get("/api/routes")
                        .param("source", "Central")
                        .param("destination", "Airport"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.route[0]").value("Central"))
                .andExpect(jsonPath("$.route[1]").value("Park"))
                .andExpect(jsonPath("$.route[2]").value("Airport"))
                .andExpect(jsonPath("$.distanceKm").value(3.0))
                .andExpect(jsonPath("$.fare").value(25.0));
    }

    @Test
    void shouldReturnNoRouteForDisconnectedStation() throws Exception {
        mockMvc.perform(get("/api/routes")
                        .param("source", "Central")
                        .param("destination", "Harbor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("No route found"));
    }

    @Test
    void shouldReturnBadRequestWhenDestinationIsMissing() throws Exception {
        mockMvc.perform(get("/api/routes")
                        .param("source", "Central"))
                .andExpect(status().isBadRequest());
    }
}
