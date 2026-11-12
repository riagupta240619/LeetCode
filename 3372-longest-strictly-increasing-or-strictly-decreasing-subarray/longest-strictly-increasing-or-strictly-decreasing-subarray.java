class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incMax = 1;
        int decMax = 1;
        int res = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                incMax++;
                res = Math.max(incMax, res);   
                decMax = 1;             
            }
            else if (nums[i] == nums[i-1]){
                incMax = 1;
                decMax = 1;
                continue;
            }
            else {
                decMax++;
                res = Math.max(decMax, res);
                incMax = 1;
            }
        }
        return res;
    }
}