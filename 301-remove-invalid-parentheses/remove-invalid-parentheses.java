class Solution {
    boolean isValid(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') count++;
            else if(ch == ')'){
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);

        boolean found = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String curr = q.peek();
                q.remove();
                if(isValid(curr)){
                    res.add(curr);
                    found = true;
                }
                if(found) continue;
                for(int j = 0;j<curr.length();++j){
                    if(curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;
                    String new_String = curr.substring(0,j) + curr.substring(j+1);
                    if(!set.contains(new_String)){
                        set.add(new_String);
                        q.add(new_String);
                    }
                }
            }
            if(found) break;
        }
        return res;
    }
}