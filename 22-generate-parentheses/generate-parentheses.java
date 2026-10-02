class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if current string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        // Add opening parenthesis if we haven't used all
        if (open < max) {
           backtrack(result, current + "(", open + 1, close, max);
        }
        
        // Add closing parenthesis if it won't make the string invalid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}