package Graph;

import java.util.*;

public class CityRoadNetwork {
    /*
     * Task 1: Choose and justify appropriate graph representation
     * Choice: Directed Weighted Graph represented via Adjacency List.
     * Justification: The graph is directed because some roads are one-way. 
     * Two-way roads can simply be modeled as two directed edges in opposite directions.
     * Weights are needed to represent distances. An adjacency list is best as cities
     * typically have sparse road networks (each intersection connects to 3-4 others usually).
     */

    static class Edge {
        String target;
        int weight;

        public Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    private Map<String, List<Edge>> adjList;

    public CityRoadNetwork() {
        adjList = new HashMap<>();
    }

    public void addIntersection(String intersection) {
        adjList.putIfAbsent(intersection, new ArrayList<>());
    }

    public void addRoad(String source, String dest, int weight, boolean isTwoWay) {
        addIntersection(source);
        addIntersection(dest);
        adjList.get(source).add(new Edge(dest, weight));
        if (isTwoWay) {
            adjList.get(dest).add(new Edge(source, weight));
        }
    }

    // Task 2: Design algorithm to find all intersections reachable from A
    public Set<String> getReachableIntersections(String start) {
        Set<String> visited = new HashSet<>();
        if (!adjList.containsKey(start)) return visited;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (Edge edge : adjList.get(current)) {
                if (!visited.contains(edge.target)) {
                    visited.add(edge.target);
                    queue.add(edge.target);
                }
            }
        }
        
        return visited;
    }

    // Task 3: Using BFS, find the path with fewest turns from A to E
    // "Fewest turns" typically translates to "fewest intersections/edges". 
    // Regular BFS finds the shortest path in an unweighted graph, ignoring weights.
    public List<String> getPathWithFewestTurns(String start, String target) {
        if (!adjList.containsKey(start) || !adjList.containsKey(target)) return new ArrayList<>();
        
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        List<String> startPath = new ArrayList<>();
        startPath.add(start);
        queue.add(startPath);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String current = path.get(path.size() - 1);
            
            if (current.equals(target)) {
                return path;
            }
            
            for (Edge edge : adjList.get(current)) {
                if (!visited.contains(edge.target)) {
                    visited.add(edge.target);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(edge.target);
                    queue.add(newPath);
                }
            }
        }
        
        return new ArrayList<>(); // No path found
    }

    /*
     * Task 4: Explain why DFS might not find the shortest distance path
     * Explanation: DFS explores as far as possible along each branch before backtracking.
     * It might find a valid path to the destination early on, but it could be a highly 
     * circuitous route with many edges or large weights. It does not explore nodes level 
     * by level (like BFS for unweighted shortest path) or prioritize nodes with lower 
     * cumulative weights (like Dijkstra's for weighted shortest path). Therefore, the 
     * first path DFS finds is rarely the shortest.
     */

    public static void main(String[] args) {
        CityRoadNetwork network = new CityRoadNetwork();
        network.addRoad("A", "B", 5, false); // one-way
        network.addRoad("B", "C", 3, true);  // two-way
        network.addRoad("A", "D", 7, true);  // two-way
        network.addRoad("D", "E", 2, false); // one-way
        network.addRoad("C", "E", 4, false); // one-way

        System.out.println("Intersections reachable from A: " + network.getReachableIntersections("A"));
        System.out.println("Path with fewest turns from A to E: " + network.getPathWithFewestTurns("A", "E"));
    }
}
