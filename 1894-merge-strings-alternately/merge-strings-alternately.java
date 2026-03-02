class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int min = Math.min(s1.length, s2.length);
        StringBuilder newString = new StringBuilder();
        for(int i = 0;i<min;i++){
            newString.append(s1[i]);
            newString.append(s2[i]);
        }
        if(s1.length > s2.length){
            while(min<s1.length){
                newString.append(s1[min++]);
            }
        }
        else{
            while(min<s2.length){
                newString.append(s2[min++]);
            }
        }
        return newString.toString();
    }
}