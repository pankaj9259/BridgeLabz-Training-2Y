package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCounter {

    /*
     * Task 1: Model this problem as a graph
     * Vertices: Each cell containing a '1' (land) is a vertex.
     * Edges: An edge exists between two adjacent cells (horizontally or vertically) 
     * if both cells contain a '1'.
     */

    // Task 2: Design algorithm using DFS to count islands
    public int numIslandsDFS(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        
        visited[r][c] = true;
        
        dfs(grid, r + 1, c, visited); // down
        dfs(grid, r - 1, c, visited); // up
        dfs(grid, r, c + 1, visited); // right
        dfs(grid, r, c - 1, visited); // left
    }

    // Task 3: Design algorithm using BFS to count islands
    public int numIslandsBFS(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        
                        for (int[] dir : directions) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1 && !visited[nr][nc]) {
                                queue.offer(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    /*
     * Task 4: Analyze time and space complexity
     * Time Complexity: O(M * N) for both BFS and DFS. We visit every cell in the grid a constant number of times.
     * Space Complexity: 
     * - DFS: O(M * N) in the worst case for the recursion stack (if the entire grid is one island).
     * - BFS: O(min(M, N)) for the queue size in the worst case (e.g., maximum diagonal width). Also O(M*N) for visited array. Overall O(M * N).
     * 
     * Task 5: Can diagonal connections be considered? How would that change the solution?
     * Yes, diagonal connections can be considered. This would change the definition of an island 
     * (8-directional connectivity instead of 4-directional).
     * To implement this, we simply need to check 8 directions instead of 4 in our DFS/BFS algorithms 
     * (up, down, left, right, and the 4 diagonals). The overall complexity would remain the same, 
     * but fewer islands might be counted as diagonally adjacent lands would now merge into single islands.
     */

    public static void main(String[] args) {
        IslandCounter counter = new IslandCounter();
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        };

        System.out.println("Number of islands (DFS): " + counter.numIslandsDFS(grid));
        System.out.println("Number of islands (BFS): " + counter.numIslandsBFS(grid));
    }
}
