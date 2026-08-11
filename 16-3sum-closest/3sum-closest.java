class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    int new_diff = Math.abs(target - sum);
                    if(new_diff<diff){
                        diff = new_diff;
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}