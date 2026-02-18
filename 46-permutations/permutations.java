class Solution {
    private void permute(List<Integer> num, List<Integer> ans, List<List<Integer>> res) {
        // Base case
        if (num.size() == 0) {
            res.add(new ArrayList<>(ans)); 
            return;
        }
        // Loop through remaining numbers
        for (int i = 0; i < num.size(); i++) {
            int current = num.get(i);
            // Create remaining list
            List<Integer> rest = new ArrayList<>();
            rest.addAll(num.subList(0, i));
            rest.addAll(num.subList(i + 1, num.size()));
            // Choose
            ans.add(current);
            // Recurse
            permute(rest, ans, res);
            // Backtrack
            ans.remove(ans.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> num = new ArrayList<>();
        for (int n : nums) {
            num.add(n);
        }
        List<List<Integer>> res = new ArrayList<>();
        permute(num, new ArrayList<>(), res);
        return res;
    }
}
