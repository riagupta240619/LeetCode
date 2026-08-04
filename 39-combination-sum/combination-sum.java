class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // Set<List<Integer>> set = new HashSet<>();    
        // int sum = 0;
        backtrack(candidates, target,0,0, new ArrayList<>(), res);  
        //for list in set add to res
        // res.addAll(set);
        return res;
    }
    public void backtrack(int[] candidates, int target,int start, int sum, List<Integer> arr, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(sum>target) return;
        for(int i = start;i<candidates.length;i++){
            // choose -> explore -> backtrack
            arr.add(candidates[i]);
            backtrack(candidates, target,i, sum+candidates[i], arr, res);
            arr.remove(arr.size()- 1);
        }
    }
}