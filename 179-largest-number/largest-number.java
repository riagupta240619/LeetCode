class Solution {
    // public int sumOfDigits(int n){
    //     if(n == 0) return 0;
    //     return n%10+sumOfDigits(n/10);
    // } 
    public String largestNumber(int[] nums) {
        // StringBuilder res = new StringBuilder();
        // List<Integer> arr = new ArrayList<>();
        // for(int i = 0;i<nums.length;i++){
        //     arr.add(nums[i]);
        // }
        // while(arr.size()>0){
        //     int max = -1;
        //     int index = -1;
        //     for (int i = 0; i < arr.size(); i++) {
        //         if (sumOfDigits(arr.get(i)) > max) {
        //             max = sumOfDigits(arr.get(i));
        //             index = i;
        //         }
        //     }
        //     res.append(arr.get(index));
        //     arr.remove(index);
        // }
        // return res.toString();


        String[] arr = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";

        StringBuilder res = new StringBuilder();
        for(String s: arr ){
            res.append(s);
        }
        return res.toString();
    }
}