class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int target = grid[m - 1][n - 1];
        int res = 0;
        // System.out.println(target);
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                // System.out.printf(i + " " + j + "%n");
                // res += Maths.min(grid[i][j-1], grid[i-1][j]);
                if(i == m-1 && j == n-1) continue;
                else if(i == m - 1){
                    grid[i][j] += grid[i][j+1];
                }
                else if(j == n - 1){
                    grid[i][j] += grid[i+1][j];
                }
                else{
                    grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
}