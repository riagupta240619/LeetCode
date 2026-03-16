class Solution {
    public boolean checkOnesSegment(String s) {
        // if(s.length() == 0 || (s.length( ) == 1 && s.charAt(0) == '0')) return false;
        // if(s.length( ) == 1 && s.charAt(0) == '1') return true;
        // for(int i = 0;i<s.length()-1;i++){
        //     char a = s.charAt(i);
        //     char b = s.charAt(i+1);
        //     if(a == '1' && b == '1') return true;
        // }
        // return false;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '1' && s.charAt(i-1) == '0'){
                return false;
            }
        }
        return true;
    }
}