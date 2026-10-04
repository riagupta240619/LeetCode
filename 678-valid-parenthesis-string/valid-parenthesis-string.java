class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open_brackets = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open_brackets.push(i);
            }else if(s.charAt(i) == '*'){
                asterisk.push(i);
            }else{
                if(!open_brackets.isEmpty()){
                    open_brackets.pop();
                }else if(!asterisk.isEmpty()){
                    asterisk.pop();
                }else{
                    return false;
                }
            }
        }
        while(!open_brackets.isEmpty() && !asterisk.isEmpty()){
            if(open_brackets.pop()>asterisk.pop()) return false;
        }
        return open_brackets.isEmpty();
    }
}