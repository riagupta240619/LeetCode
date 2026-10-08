class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '(') {
                count++;
                if(count == 1) continue;
                else{
                    res.append(ch);
                }
            }
            else{
                count--;
                if(count == 0) continue;
                else{
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
}