package Graph;

import java.util.*;

public class NetworkPacketRouting {

    /*
     * Task 1: Represent the network using both adjacency matrix and adjacency list
     */
    
    // 1. Adjacency List Representation
    private Map<String, List<String>> adjList;
    
    // 2. Adjacency Matrix Representation mapping
    private int[][] adjMatrix;
    private Map<String, Integer> routerToIndex;
    private String[] indexToRouter;

    public NetworkPacketRouting(String[] routers) {
        adjList = new HashMap<>();
        int n = routers.length;
        adjMatrix = new int[n][n];
        routerToIndex = new HashMap<>();
        indexToRouter = new String[n];
        
        for (int i = 0; i < n; i++) {
            adjList.put(routers[i], new ArrayList<>());
            routerToIndex.put(routers[i], i);
            indexToRouter[i] = routers[i];
        }
    }

    public void addConnection(String u, String v) {
        // Update List
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        
        // Update Matrix
        int i = routerToIndex.get(u);
        int j = routerToIndex.get(v);
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    /*
     * Task 2: Calculate space complexity for both representations
     * V = number of routers (vertices), E = number of connections (edges)
     * Adjacency Matrix: O(V^2) space. Needs a VxV matrix regardless of how many edges exist.
     * Adjacency List: O(V + E) space. Only stores actual edges for each vertex.
     */

    // Task 3: Design algorithm to find if network is connected
    public boolean isConnected() {
        if (adjList.isEmpty()) return true;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        String startNode = adjList.keySet().iterator().next();
        queue.add(startNode);
        visited.add(startNode);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return visited.size() == adjList.size();
    }

    // Task 4: If connection R4-R5 fails, design algorithm to find alternative paths from R1 to R6
    // Note: Based on the given topology, R4 is a bridge. Removing R4-R5 disconnects R1 and R6.
    public List<List<String>> getAlternativePathsWithoutEdge(String start, String end, String brokenU, String brokenV) {
        List<List<String>> paths = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> currentPath = new ArrayList<>();
        
        currentPath.add(start);
        visited.add(start);
        
        dfsFindPaths(start, end, brokenU, brokenV, visited, currentPath, paths);
        return paths;
    }
    
    private void dfsFindPaths(String current, String end, String brokenU, String brokenV, 
                              Set<String> visited, List<String> currentPath, List<List<String>> paths) {
        if (current.equals(end)) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        
        for (String neighbor : adjList.get(current)) {
            // Skip the broken edge
            if ((current.equals(brokenU) && neighbor.equals(brokenV)) || 
                (current.equals(brokenV) && neighbor.equals(brokenU))) {
                continue;
            }
            
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                currentPath.add(neighbor);
                
                dfsFindPaths(neighbor, end, brokenU, brokenV, visited, currentPath, paths);
                
                // Backtrack
                visited.remove(neighbor);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    // Task 5: Using BFS, find the minimum number of hops required for a packet to travel from R1 to R6
    public int getMinimumHops(String start, String end) {
        if (start.equals(end)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(start);
        visited.add(start);
        int hops = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(end)) return hops;
                
                for (String neighbor : adjList.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            hops++;
        }
        
        return -1; // Not reachable
    }

    public static void main(String[] args) {
        String[] routers = {"R1", "R2", "R3", "R4", "R5", "R6"};
        NetworkPacketRouting network = new NetworkPacketRouting(routers);
        
        network.addConnection("R1", "R2");
        network.addConnection("R1", "R3");
        network.addConnection("R2", "R4");
        network.addConnection("R3", "R4");
        network.addConnection("R4", "R5");
        network.addConnection("R5", "R6");
        
        System.out.println("Is network connected? " + network.isConnected());
        System.out.println("Minimum hops from R1 to R6: " + network.getMinimumHops("R1", "R6"));
        
        System.out.println("Alternative paths from R1 to R6 if R4-R5 fails: ");
        List<List<String>> altPaths = network.getAlternativePathsWithoutEdge("R1", "R6", "R4", "R5");
        if (altPaths.isEmpty()) {
            System.out.println("No alternative paths found. R4-R5 is a critical bridge.");
        } else {
            System.out.println(altPaths);
        }
    }
}
