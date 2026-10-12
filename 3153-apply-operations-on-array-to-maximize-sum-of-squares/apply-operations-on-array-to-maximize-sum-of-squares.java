class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1000000007;
        int[] cnt = new int[30];
        for(int num : nums){
            for(int i = 0;i<30;i++){
                if((num & (1 << i)) != 0){
                    cnt[i]++;
                }
            }
        }
        long res = 0;
        for(int i = 0;i<k;i++){
            long curr = 0;
            for(int j = 29;j>=0;j--){
                if(cnt[j] > 0){
                    curr += (1 << j);
                    cnt[j]--;
                }
            }
            res = (res + curr * curr) % mod;
        }
        return (int)res;
    }
}