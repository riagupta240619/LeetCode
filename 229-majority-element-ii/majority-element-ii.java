class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int r = n/3;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i])>r && (!res.contains(nums[i]))){
                res.add(nums[i]);
            }
        }
        return res;
    }
}