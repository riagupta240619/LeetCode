class Solution {
    public int longestConsecutive(int[] nums) {
        // if (nums == null || nums.length == 0) return 0;
        // Arrays.sort(nums);
        // int res = 1;
        // int temp = 1;
        // for(int i = 0;i<nums.length-1;i++){
        //     if(nums[i+1] == nums[i]+1){
        //         temp++;
        //     }else if (nums[i + 1] != nums[i]){
        //         res = Math.max(temp,res);
        //         temp=1;
        //     }
        // }
        // return Math.max(temp,res);

        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int maxLen = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curr = num;
                int currstreak = 1;
                while(set.contains(curr+1)){
                    curr++;
                    currstreak++;
                }
                maxLen = Math.max(maxLen, currstreak);
            }
        }
        return maxLen;
    }
}