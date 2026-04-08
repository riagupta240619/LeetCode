class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[k];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int v = entry.getValue();
            pq.add(v);            
        }
        while(k-- > 0){
            int top = pq.poll();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == top) {
                    arr[idx++] = entry.getKey();
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        return arr;
    }
}