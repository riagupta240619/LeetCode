class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        for(int i : nums){
            l.add(i);
        }
        Collections.rotate(l, k);
        for(int i = 0;i<l.size();i++){
            nums[i] = l.get(i);
        }
    }
}