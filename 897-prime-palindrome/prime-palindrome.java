class Solution {
    public int primePalindrome(int n) {
        int max = Integer.MAX_VALUE;
        for(int i = n;i<max;i++){
            if(i > 10000000 && i < 100000000){
                i = 100000000;
            }
            if(i > 100000 && i < 1000000){
                i = 1000000;
            }
            if(isPallindrome(i) && isPrime(i)){
                return i;
            }
        }
        return -1;
    }
    private boolean isPallindrome(int x){
        boolean a = true;
        StringBuilder s = new StringBuilder(String.valueOf(x));;
        StringBuilder s2 = new StringBuilder(String.valueOf(x));;
        s2 = s2.reverse();
        if(s.toString().equals(s2.toString())) return true;
        else return false;
    }
    private boolean isPrime(int x){
        boolean b = true;
        if(x<=1) return false;
        for(int i = 2;i*i<=x;i++){
            if(x%i == 0){
                b = false;
                break;
            }
        }
        return b;
    }
}