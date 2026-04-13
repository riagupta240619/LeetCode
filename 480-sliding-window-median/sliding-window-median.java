class Solution {
    private void binarySearch(List<Integer> l, int newElement){
        int left = 0;
        int right = l.size() - 1;
        while(left<=right){
            int mid = (left + right)/2;
            if(l.get(mid) == newElement){
                l.add(mid, newElement);
                return;
            }
            else if(l.get(mid) < newElement){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        l.add(left, newElement);
        
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<k;i++){
            q.add(nums[i]);
        }
        List<Double> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(q);
        Collections.sort(temp);
        if (k % 2 == 1) {
            l.add((double) temp.get(k / 2));
        } else {
            double median = ((double) temp.get(k / 2 - 1) + temp.get(k / 2)) / 2.0;
            l.add(median);
        }
        // temp.clear();

        for(int i = k;i<nums.length;i++){
            int val = q.poll();
            q.add(nums[i]);
            temp.remove(Integer.valueOf(val));
            binarySearch(temp, nums[i]);
            // temp.addAll(q);
            // Collections.sort(temp);
            if (k % 2 == 1) {
                l.add((double) temp.get(k / 2));
            } else {
                double median = ((double) temp.get(k / 2 - 1) + temp.get(k / 2)) / 2.0;
                l.add(median);
            }
            // temp.clear();
        }
        double[] res = new double[l.size()];
        for(int i = 0;i<l.size();i++){
            res[i] = l.get(i);
        }
        return res;
    }
}