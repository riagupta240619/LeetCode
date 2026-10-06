class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> open_brackets = new Stack<>();
        Stack<Integer> closing_brackets = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') open_brackets.push(i);
            else if(ch == ')' && !open_brackets.isEmpty()) open_brackets.pop();
            else closing_brackets.push(i);
        }
        // if(open_brackets.isEmpty() && closing_brackets.isEmpty()) return 0;
        // if(!open_brackets.isEmpty() && closing_brackets.isEmpty()) return open_brackets.size();
        // if(open_brackets.isEmpty() && !closing_brackets.isEmpty()) return closing_brackets.size();
        // int res = 0;
        // int open = open_brackets.size();
        // int close = closing_brackets.size();
        // while(open!=0 || close!=0){
        //     open_brackets.pop();
        //     open--;
        //     closing_brackets.pop();
        //     close--;
        //     res++; 
        // }
        // return res + open + close;
        return open_brackets.size() + closing_brackets.size();
    }
}