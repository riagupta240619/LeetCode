class Solution {
    public int numSteps(String s) {
        // This way of conversion ocauses TLE
        // int n = Integer.parseInt(s,2);
        // int p = 0;
        // int n = 0;
        // for(int i = s.length()-1;i>=0;i--){
        //     char ch = s.charAt(i);
        //     int val = ch - '0';
        //     int b = (int) (val * Math.pow(2, p));
        //     n += b;
        //     p++;
        // }
        // int c = 0;
        // while(n!=1){
        //     if(n%2!=0){
        //         n++;
        //         c++;
        //     }
        //     else{
        //         c++;
        //         n = n/2;
        //     }
        // }  
        // return c;

        // APPROACH - 2
        int c = 0;
        int a = 0;
        for(int i = s.length() - 1;i>0;i--){
            int bit = (s.charAt(i) - '0') + a;
            if(bit == 1){
                c += 2;
                a = 1;
            }
            else{
                c++;
            }
        }
        return c + a;
    }
}