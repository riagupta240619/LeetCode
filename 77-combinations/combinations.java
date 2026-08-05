class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        int idx = 0;
        for(int i = 1;i<=n;i++){
            arr.add(i);
        }  
        // for(int i = 0;i<arr.length;i++){
        //     System.out.print(arr[i] + " ");
        // }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,k, new ArrayList<>(), arr,0,0);
        return res;
    }
    public static void backtrack(List<List<Integer>> res, int k, List<Integer> temp, List<Integer> arr, int start, int length){
        if(length == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i<arr.size();i++){
            // choose -> explore -> remove
            temp.add(arr.get(i));
            backtrack(res, k, temp, arr, i+1, temp.size());
            temp.remove(temp.size() - 1);
        }
    }
}