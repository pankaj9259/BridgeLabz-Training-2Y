package Graph;

import java.util.*;

public class SocialNetworkConnection {
    /*
     * Task 1: Choose appropriate graph representation and justify your choice
     * Choice: Adjacency List using a HashMap where keys are user names (Strings)
     * and values are Lists/Sets of friends (Strings).
     * Justification: Social networks are typically sparse graphs. Most people are friends 
     * with a very small fraction of the total user base. An adjacency list saves significant 
     * space (O(V + E)) compared to an adjacency matrix (O(V^2)). It also allows for fast 
     * iteration over a user's friends.
     */

    private Map<String, List<String>> adjList;

    public SocialNetworkConnection() {
        adjList = new HashMap<>();
    }

    public void addFriendship(String u, String v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Undirected
    }

    // Task 2: Find all friends of a given user (e.g., Alice)
    public List<String> getFriends(String user) {
        return adjList.getOrDefault(user, new ArrayList<>());
    }

    // Task 3: Check if two users are directly connected
    public boolean areDirectlyConnected(String u, String v) {
        if (!adjList.containsKey(u)) return false;
        return adjList.get(u).contains(v);
    }

    // Task 4: Find the degree of separation (shortest path) between two users
    public int getDegreeOfSeparation(String start, String target) {
        if (!adjList.containsKey(start) || !adjList.containsKey(target)) return -1;
        if (start.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        int degree = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(target)) {
                    return degree;
                }
                
                for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            degree++;
        }
        
        return -1; // Not connected
    }

    public static void main(String[] args) {
        SocialNetworkConnection network = new SocialNetworkConnection();
        network.addFriendship("Alice", "Bob");
        network.addFriendship("Alice", "Charlie");
        network.addFriendship("Bob", "David");
        network.addFriendship("Charlie", "Eve");
        network.addFriendship("David", "Eve");

        System.out.println("Friends of Alice: " + network.getFriends("Alice"));
        System.out.println("Are Bob and Eve directly connected? " + network.areDirectlyConnected("Bob", "Eve"));
        System.out.println("Degree of separation between Alice and Eve: " + network.getDegreeOfSeparation("Alice", "Eve"));
    }
}
