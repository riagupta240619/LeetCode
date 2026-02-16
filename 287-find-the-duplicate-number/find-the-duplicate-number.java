class Solution {
    public int findDuplicate(int[] nums) {
        // int res = 0;
        // for(int i = 1;i<nums.length;i++){
        //     res ^= i;
        // }
        // for(int i = 0;i<nums.length;i++){
        //     res ^= nums[i];
        // }
        // return res;
        // above testcase fails when whole array is same

        // 2
        int res = 0;
        Arrays.sort(nums);
        for(int i= 0;i<nums.length -1 ;i++){
            if(nums[i] == nums[i+1]){
                res = nums[i];
                break;
            }
        }
        return res;
    }
}