class Solution {
    static void lps(String pat, int[] lps){
        int len = 0;
        lps[0] = 0;
        int m = pat.length();
        int i = 1;
        while(i<m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[len] = len;
                    i++;
                }
            }
        }
    }
    static int search(String txt, String pat){
        int n = txt.length();
        int m = pat.length();
        int res = 0;
        int[] lps = new int[m];
        lps(pat, lps);
        int i = 0;
        int j = 0;
        while(i<n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                res = i-j;
                j = lps[j-1];
                return res;
            }
            else if(i<n && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        // int n = haystack.length();
        // int m = needle.length();
        // for(int i = 0;i<=n-m;i++){
        //     if(haystack.substring(i,i+m).equals(needle)) return i;
        // }
        // return -1;

        //KMP algorithm
        int res = search(haystack, needle);
        return res;
    }
}