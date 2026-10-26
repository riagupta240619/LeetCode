// class Solution {
//     int m, n;

//     void dfs(int[][] grid, int r, int c) {
//         if (r < 0 || c < 0 || r >= m || c >= n
//                 || grid[r][c] == 1) {
//             return;
//         }

//         grid[r][c] = 1; // Mark visited

//         dfs(grid, r + 1, c); // Down
//         dfs(grid, r - 1, c); // Up
//         dfs(grid, r, c + 1); // Right
//         dfs(grid, r, c - 1); // Left
//     }

//     public int closedIsland(int[][] grid) {
//         m = grid.length;
//         n = grid[0].length;

//         // Remove boundary-connected islands
//         for (int i = 0; i < m; i++) {
//             dfs(grid, i, 0);
//             dfs(grid, i, n - 1);
//         }

//         for (int j = 0; j < n; j++) {
//             dfs(grid, 0, j);
//             dfs(grid, m - 1, j);
//         }

//         // Count remaining closed islands
//         int count = 0;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 0) {
//                     count++;
//                     dfs(grid, i, j);
//                 }
//             }
//         }

//         return count;
//     }
// }
import java.util.*;

class Solution {
    int m, n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    void bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 1; // Mark visited immediately

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n
                        && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Step 1: Remove boundary-connected land
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) bfs(grid, i, 0);
            if (grid[i][n - 1] == 0) bfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) bfs(grid, 0, j);
            if (grid[m - 1][j] == 0) bfs(grid, m - 1, j);
        }

        // Step 2: Count remaining islands
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }
}