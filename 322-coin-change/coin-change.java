class Solution {
    public int coinChange(int[] coins, int amount) {

        // Arrays.sort(coins);

        // int x = amount;
        // int count = 0;
        // int total = 0;

        // for(int i = coins.length - 1;i>=0;i--){
        //     while(amount >= coins[i]){
        //         amount -= coins[i];
        //         count++;
        //         total += coins[i];
        //     }
        //     if(total == x) return count;
            
        // }
        
        // return -1;
        //make an array dp and keep check on how you can reach n-1;
        int[] dp = new int[amount+1];
        for(int i = 1;i<=amount;i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int coin: coins){
                if(i>=coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}