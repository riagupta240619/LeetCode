class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            st.push(c);
        }
        for(int i = t.length() - 1;i>=0;i--){
            char ch = t.charAt(i);
            if(!st.isEmpty() && ch == st.peek()){
                st.pop();
            }
            else{
                continue;
            }
        }
        return st.isEmpty();
    }
}