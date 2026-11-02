# Metro Route & Fare Planner

A Java-based Metro Route and Fare Planner built using **Java 21, Spring Boot, and Dijkstra's Shortest Path Algorithm**.

The application calculates the shortest route between two metro stations and provides the estimated travel distance and fare through a REST API and a simple web interface.

## Features

- Shortest route calculation using Dijkstra's algorithm.
- Weighted, undirected graph representation of metro stations.
- Distance calculation between stations.
- Estimated fare calculation.
- REST API built with Spring Boot.
- Simple frontend using HTML, CSS, and JavaScript.
- Input validation and error handling.
- Unit and controller tests using JUnit and Spring Boot testing tools.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Core programming |
| Spring Boot | Backend and REST APIs |
| Maven | Dependency management and build |
| Dijkstra's Algorithm | Shortest path calculation |
| HTML, CSS, JavaScript | Frontend |
| JUnit | Testing |

## Project Structure

```text
metro-route-fare-planner/
├── src/
│   ├── main/
│   │   ├── java/com/shivam/metro/metroroutefareplanner/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   └── graph/
│   │   └── resources/
│   │       └── static/
│   │           └── index.html
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 21
- Git
- IntelliJ IDEA or another Java IDE

### Run Locally

1. Clone the repository:

```bash
git clone https://github.com/Shivam3229/metro-route-fare-planner.git
```

2. Navigate to the project directory:

```bash
cd metro-route-fare-planner
```

3. Run the application:

```bash
.\mvnw.cmd spring-boot:run
```

4. Open the frontend:

```text
http://localhost:8080/
```

## API Usage

### Find the Shortest Route

**Endpoint:**

```http
GET /api/routes?source=Central&destination=Airport
```

**Example response:**

```json
{
  "source": "Central",
  "destination": "Airport",
  "route": ["Central", "Park", "Airport"],
  "distanceKm": 3.0,
  "fare": 25.0
}
```

## Algorithm

The project uses **Dijkstra's Shortest Path Algorithm** to find the minimum-distance route between two stations.

- Graph representation: Adjacency List
- Edge weights: Distance between stations
- Priority Queue: Efficient selection of the next closest station
- Parent Map: Route reconstruction

## Current Limitations

- Currently uses a small illustrative metro network.
- Station connections and distances are demo data, not verified official Delhi Metro data.
- Fare calculation uses an illustrative formula, not official DMRC fare rules.
- The station list is currently maintained in the backend/frontend rather than loaded from an authoritative live dataset.

## Future Improvements

- Integrate verified Delhi Metro station and connectivity data.
- Implement data-driven station and connection loading.
- Add metro line and interchange information.
- Replace illustrative fare calculation with verified official fare rules.
- Load station options dynamically from the backend.
- Improve the frontend with an interactive metro route visualization.

## Author

**Shivam**

GitHub: [Shivam3229](https://github.com/Shivam3229)
