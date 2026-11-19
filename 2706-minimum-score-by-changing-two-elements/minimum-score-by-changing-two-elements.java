class Solution {
    public int minimizeSum(int[] nums) {
        // high = max abs diff
        // low = min abs diff
        // score = sum(high, low);
        // change the minimum or maximum value
        Arrays.sort(nums);
        int n = nums.length;
        int case1 = nums[n-1] - nums[2];
        int case2 = nums[n-2] - nums[1];
        int case3 = nums[n-3] - nums[0];
        return Math.min(case1, Math.min(case2, case3)); 
    }
}