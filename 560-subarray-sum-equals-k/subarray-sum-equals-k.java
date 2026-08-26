class Solution {
    public int subarraySum(int[] nums, int k) {
        // int left = 0;
        // int right = 0;
        // int sum = 0;
        // int res = 0;
        // int i = 0;
        // while(left<nums.length-1){
        //     sum += nums[i];
        //     if(sum == k){
        //         res++;
        //         left = right+1;
        //         right++;
        //         sum = 0;
        //     }else if(sum<k){
        //         right++;
        //         sum+=nums[right];
        //     }else{
        //         sum -= nums[left];
        //         left++;
        //     }
        // }
        // return res;

        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                res+= map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}