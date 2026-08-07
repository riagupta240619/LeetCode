class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int max = 0;
        int[] dp = new int[n];
        for(int i = 1;i<n;i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = 2;
                    if(i>=2){
                        dp[i] += dp[i-2];
                    }
                }else{
                    int left_index = i-dp[i-1]-1;
                    if(left_index>=0 && s.charAt(left_index)=='('){
                        dp[i] = i-left_index+1;
                        if(left_index>0){
                            dp[i] += dp[left_index-1];
                        }
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}