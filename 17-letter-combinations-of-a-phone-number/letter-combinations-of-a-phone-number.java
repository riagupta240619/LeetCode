class Solution{
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, map, digits, new StringBuilder(), 0);
        return res;
    }
    public void backtrack(List<String> res, String[] map, String digits, StringBuilder curr, int index){
        if(curr.length() == digits.length()){
            res.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for(int i = 0;i<letters.length();i++){
            curr.append(letters.charAt(i));
            backtrack(res, map, digits, curr, index+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}