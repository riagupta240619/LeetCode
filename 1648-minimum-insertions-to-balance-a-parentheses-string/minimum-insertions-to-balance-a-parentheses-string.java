class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int neededRight = 0; // Tracks required ')'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                neededRight += 2;
                // If neededRight is odd, it means we had an unmatched single ')' 
                // from a previous step, so we insert one ')' to pair it up.
                if (neededRight % 2 != 0) {
                    insertions++;
                    neededRight--;
                }
            } else { // c == ')'
                neededRight--;
                // If neededRight becomes negative, it means we encountered a ')' 
                // without an opening '('. We need to insert a '(' (which adds 2 to neededRight).
                if (neededRight < 0) {
                    insertions++;
                    neededRight += 2;
                }
            }
        }

        return insertions + neededRight;
    }
}