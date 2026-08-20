class Solution {
    public int findJudge(int n, int[][] trust) {
        // if (n == 1 && trust.length == 0) return 1;
        // int res = trust[0][1];
        // int count = 0;
        // for(int i = 0;i<trust.length;i++){
        //     if(trust[i][0] == res ) return -1;
        //     if(trust[i][1] == res) count++;
        // }
        // if (count == n - 1)
        //     return res;

        // return -1;

        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];

            out[a]++;
            in[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}