class Solution {
    public int maxRotateFunction(int[] nums) {
        // int max = Integer.MIN_VALUE;
        // int n = nums.length;
        // // int k = n-1;
        // //outer loop rotaate
        // for(int i = 0;i<n;i++){
        //     if(i == 0){
        //         max = 0;
        //         continue;
        //     }
        //     int sum = 0;
        //     //inner loop multiplying values 
        //     for(int j = 0;j<n;j++){
        //         sum += j * nums[(j+i)%n];
        //     }
        //     max = Math.max(sum, max);
        // }
        // return max;
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            f += i * nums[i];
        }
        int max = f;
        for(int k = 1; k < n; k++){
            f = f + sum - n * nums[n - k];
            max = Math.max(max, f);
        }
        return max;
    }
}