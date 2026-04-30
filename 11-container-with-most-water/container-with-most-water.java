class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            res = Math.max(res, h*width);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}