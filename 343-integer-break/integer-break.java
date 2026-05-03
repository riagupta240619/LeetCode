class Solution {
    public int integerBreak(int n) {
        // dp keep the number
        // break the number even further
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3;i<=n;i++){
            for(int j = 1;j<i;j++){
                int left = Math.max(j,dp[j]);
                int right = Math.max(i-j, dp[i-j]);
                dp[i] = Math.max(dp[i], left * right);
            }
        }
        return dp[n];
    }
}