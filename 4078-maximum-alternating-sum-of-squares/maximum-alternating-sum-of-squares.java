class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        int x = n/2;
        long res = 0;
        for(int i = x;i<n;i++){
            res += nums[i];
        }
        for(int i = 0;i<x;i++){
            res -= nums[i];
        }
        return res;
    }
}