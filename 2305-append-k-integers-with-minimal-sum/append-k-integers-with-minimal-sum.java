class Solution {
    public long minimalKSum(int[] nums, int k) {
        // Arrays.sort(nums);
        // int c = k;
        // int starting = nums[0];
        // int res = 0;
        // while(c!=0)
        //     for(int i = 0;i<nums.length-1;i++){
        //         if(nums[i+1] == starting + 1) continue;
        //         else{
        //             while(nums[i+1] != starting + 1){
        //                 res += starting + 1;
        //                 starting = starting + 1;
        //                 c--;
        //             }
        //         }
        //     }    
        // }    
        // return res;        
        
        // while k>0
        // minimum value you can take is 1
        // if array.contains val continue
        // array.add val
        // val++
        // int c = k;
        // int min = 1;
        // int res = 0;
        // List<Integer> arr = new ArrayList<>();
        // for(int i = 0;i<nums.length;i++){
        //     arr.add(nums[i]);
        // }
        // while(c>0){
        //     if(arr.contains(min)){
        //         min++;
        //         continue;
        //     }
        //     else{
        //         res += min;
        //         arr.add(min);
        //         min++;
        //         c--;
        //     }
        // }
        // return res;

        // Arrays sort
        // while k>0
        // minimum value you can take is 1
        // two pointer approach:
        // pointer 1 = starting index value
        // if pointer 1 == min min++, pointer1++,
        // val++
        // Arrays.sort(nums);
        // int p1 = nums[0];
        // int res = 0;
        // int min = 1;
        // int c = k;
        // for(int i = 0;i<nums.length;i++){
        //     if(nums[i] == min){
        //         min++;
        //     }
        //     else{
        //         res+=min;
        //         min++;
        //         c--;
        //     }
        // }
        // if(c==0) return res;
        // while(c>0) {
        //     res+=min;
        //     min++;
        // }
        // return res;

        // Arrays.sort(nums);
        // int c = k;
        // int min = 1;
        // long res = 0;
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // while(c > 0){
        //     if(!set.contains(min)){
        //         res += min;
        //         set.add(min);
        //         c--;
        //     }
        //     min++;
        // }
        // return res;

        // Sort nums
        // Remove duplicates while traversing
        // Keep track of smallest possible number curr
        // For each num:
        // If gap exists → take numbers from gap
        // If k still remains → take numbers after last element

        Arrays.sort(nums);
        long res = 0;
        long min = 1;
        for(int num : nums){
            if(num<min) continue;
            long c = num - min;
            if(c>0){
                long a = Math.min(k,c);
                long l = min + a - 1;
                res += (min + l) * a/2;
                k-=a;
                if(k==0) return res;
            }
            min = (long) num + 1;
        }
        if(k>0){
            long l = min + k - 1;
            res += (min + l) * k/2;
        }
        return res;
    }
}