class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // dp[i][j][0] = ways entering while moving right
        // dp[i][j][1] = ways entering while moving down
        int[][][] dp = new int[m][n][2];

        // Starting cell: one initial path
        dp[0][0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int right = dp[i][j][0];
                int down = dp[i][j][1];

                if (grid[i][j] == 0) {

                    // Empty cell: both incoming directions can continue
                    int ways = (int)(((long)right + down) % MOD);

                    // Move right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (int)(((long)dp[i][j + 1][0] + ways) % MOD);
                    }

                    // Move down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (int)(((long)dp[i + 1][j][1] + ways) % MOD);
                    }

                } else {

                    // Mirror: moving right -> reflected down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (int)(((long)dp[i + 1][j][1] + right) % MOD);
                    }

                    // Mirror: moving down -> reflected right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (int)(((long)dp[i][j + 1][0] + down) % MOD);
                    }
                }
            }
        }

        // Both incoming directions can reach the destination
        return (int)(((long)dp[m - 1][n - 1][0]
                    + dp[m - 1][n - 1][1]) % MOD);
    }
}