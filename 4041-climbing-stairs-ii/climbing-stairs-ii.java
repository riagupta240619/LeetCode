class Solution {
    public int climbStairs(int n, int[] costs) {
        // “At each step, I consider the minimum cost of reaching from the previous 1, 2, or 3 steps and add the corresponding step cost. Since transitions are fixed (3 options), this is constant transition DP.”
        int sum = 0;
        double[] dp = new double[n+1];
        dp[0] = 0;
        if (n >= 1)
            dp[1] = costs[0] + 1;

        if (n >= 2)
            dp[2] = Math.min(
                dp[0] + costs[1] + 4,
                dp[1] + costs[1] + 1
            );    
        for(int i = 3;i<=n;i++){
            dp[i] = Math.min(
                dp[i-1] + costs[i-1] + Math.pow(1, 2),
                Math.min(
                    dp[i-2] + costs[i-1] + Math.pow(2, 2),
                    dp[i-3] + costs[i-1] + Math.pow(3, 2)
                )
            );
            System.out.print(dp[i] +" ");
        }
        return (int)dp[n];
    }
}