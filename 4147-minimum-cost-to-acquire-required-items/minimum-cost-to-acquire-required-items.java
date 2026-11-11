class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // if(need1 == 0 && need2 == 0) return 0;
        // long res = 0;
        // int min = Integer.MAX_VALUE;
        // while(need1 > 0 || need2 > 0){
        //     if(need1>0 && need2>0){
        //         min = Math.min(
        //             cost1,
        //             Math.min(
        //                 cost2,
        //                 costBoth
        //             )
        //         );
        //     }
        //     else if(need1>0 && need2<=0) min = Math.min(cost1,costBoth); 
        //     else if(need2>0 && need1<=0) min = Math.min(cost2,costBoth); 
        //     else{
        //         min = Math.min(cost1,cost2); 
        //     }

        //     if(min == cost1) need1--;
        //     else if(min == cost2) need2--;
        //     else{
        //         need1--;
        //         need2--;
        //     }
        //     res += min;
        // }
        // return res;
        
        long shared = Math.min((long)need1, (long)need2);

        long left1 = need1 - shared;
        long left2 = need2 - shared;

        long pairCost = Math.min((long)costBoth,
                                 (long)cost1 + cost2);

        long res = shared * pairCost;

        res += left1 * Math.min((long)cost1, (long)costBoth);
        res += left2 * Math.min((long)cost2, (long)costBoth);

        return res;
    }
}