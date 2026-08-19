class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        int mid = (left + right)/2;
        while(left<=mid){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}