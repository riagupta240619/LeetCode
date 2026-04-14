class Solution {
    public void permutation(List<List<Integer>> res, List<Integer> ans, List<Integer> arr){
        if(arr.size() == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0;i<arr.size();i++){
            int val = arr.get(i);
            //choose
            ans.add(val);
            arr.remove(i);
            //explore
            permutation(res,ans, arr);
            //backtrack
            arr.add(i, val);
            ans.remove(ans.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        permutation(l, ans, arr);
        return l;
    }
}