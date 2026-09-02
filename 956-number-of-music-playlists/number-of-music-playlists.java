// class Solution {
//     // int ans = 0;
//     public int numMusicPlaylists(int n, int goal, int k) {
//         List<Integer> songs = new ArrayList<>();
//         for(int i = 1;i<=n;i++){
//             songs.add(i);
//         }
//         boolean[] used = new boolean[n];
//         List<Integer> temp = new ArrayList<>();
//         backtrack(songs, goal,k, temp, used);
//         return ans % 1000000007;
//     }
//     public void backtrack(List<Integer> songs, int goal,int k, List<Integer> temp, boolean[] used){
//         if(temp.size() == goal){
//             boolean allUsed = true;
//             for (boolean songUsed : used) {
//                 if (!songUsed) {
//                     return;
//                 }
//             }
//             ans++;
//             return;
//         }
//         for(int i = 0;i<songs.size();i++){
//             int song = songs.get(i);
//             boolean canPlay = true;
//             int start = Math.max(0, temp.size() - k);
//             for (int j = start; j < temp.size(); j++) {
//                 if (temp.get(j).equals(song)) {
//                     canPlay = false;
//                     break;
//                 }
//             }
//             if (!canPlay) {
//                 continue;
//             }
//             boolean wasUsed = used[i];
//             used[i] = true;
//             temp.add(songs.get(i));
//             backtrack(songs, goal,k, temp, used);
//             temp.remove(temp.size() - 1);
//             used[i] = wasUsed;
//         }
//     }
// }
class Solution {

    int MOD = 1_000_000_007;

    public int numMusicPlaylists(int n, int goal, int k) {

        long[][] dp = new long[goal + 1][n + 1];

        // Base case
        dp[0][0] = 1;

        for (int i = 0; i < goal; i++) {

            for (int j = 0; j <= n; j++) {

                // Add a new song
                if (j < n) {

                    dp[i + 1][j + 1] =
                        (dp[i + 1][j + 1]
                        + dp[i][j] * (n - j)) % MOD;
                }

                // Repeat an old song
                if (j > k) {

                    dp[i + 1][j] =
                        (dp[i + 1][j]
                        + dp[i][j] * (j - k)) % MOD;
                }
            }
        }

        return (int) dp[goal][n];
    }
}