class Solution {
    public int concatenatedBinary(int n) {
       // StringBuilder s = new StringBuilder();
       //  for (int i = 1; i <= n; i++) {
       //      s.append(Integer.toBinaryString(i));
       //  }
       //  String x = s.toString();
       //  long res = Long.parseLong(x, 2); 
       //  return (int) res;
        long MOD = 1000000007;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int bits = Integer.toBinaryString(i).length();
            ans = ((ans << bits) + i) % MOD;
        }
        return (int) ans;
    }
}