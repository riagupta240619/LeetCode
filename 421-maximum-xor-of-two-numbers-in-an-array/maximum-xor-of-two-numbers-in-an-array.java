class Solution {
    public int findMaximumXOR(int[] nums) {
        // The optimal approach uses a Bitwise Trie (Prefix Tree).
        // Idea:
        // Store binary representation of numbers.
        // While inserting numbers, try to choose the opposite bit to maximize XOR.
        int max = 0;
        int mask = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 31;i>=0;i--){
            mask |= (1 << i);
            set.clear();
            for(int num : nums){
                set.add(num & mask);
            }

            int candidate = max | (1 << i);

            for(int prefix : set){
                if(set.contains(prefix ^ candidate)){
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }
}