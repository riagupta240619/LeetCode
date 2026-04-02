class MonotonicQueue{
    Deque<Integer> dq = new LinkedList<>();
    public void push(int x){
        while(!dq.isEmpty() && dq.peekLast()<x){
            dq.pollLast();
        }
        dq.addLast(x);
    }
    public void pop(int x){
        if(!dq.isEmpty() && dq.peekFirst() == x){
            dq.pollFirst();
        }
    }
    public int max(){
        return dq.peekFirst();
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Queue<Integer> q = new LinkedList<>();

        // for(int i = 0;i<k;i++){
        //     q.add(nums[i]);
        // }

        // List<Integer> res = new ArrayList<>();
        // int a = Collections.max(q);
        // res.add(a);

        // for(int i = k;i<nums.length;i++){
        //     q.remove();
        //     q.add(nums[i]);
        //     int x = Collections.max(q);
        //     res.add(x);
        // }

        // int[] arr = new int[res.size()];
        // for(int i = 0;i<res.size();i++){
        //     arr[i] = res.get(i);
        // }
        // return arr;
        MonotonicQueue mq = new MonotonicQueue();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i = 0;i<k;i++){
            mq.push(nums[i]);
        }
        res[0] = mq.max();
        for(int i = k;i<n;i++){
            mq.push(nums[i]);
            mq.pop(nums[i-k]);
            res[i-k+1] = mq.max();
        }
        return res;
    }
}