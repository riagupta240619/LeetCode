class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char ch : s.toCharArray()){
            if(ch == '(') stack.push(0);
            else{
                int inner_score = stack.pop();
                int current_score = Math.max(2*inner_score, 1);
                stack.push(stack.pop() + current_score);
            }
        }
        return stack.pop();
    }
}