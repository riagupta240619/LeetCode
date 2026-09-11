class Solution {
    public int totalNumbers(int[] digits) {
        // int res = 0;
        // int even_count = 0;
        // int distinct_count = 0;
        // int length = digits.length;
        // int zero_count = 0;
        // List<Integer> list = new ArrayList<>();
        // for(int i = 0;i<length;i++){
        //     if(list.contains(digits[i])) continue;
        //     distinct_count++;
        //     list.add(digits[i]);
        // }
        // for(int i = 0;i<length;i++){
        //     if(digits[i]%2 == 0) even_count++;
        //     if(digits[i] == 0) zero_count++;
        // }
        // if(even_count == 0) return res;
        // if(distinct_count == 1) return 1;
        // if(distinct_count>=3 && zero_count == 0){
        //     int hun = length - 1;
        //     int ten = length - 2;
        //     return even_count * hun * ten;
        // }
        // //zero case and distinct >=3
        // if(distinct_count >= 3 && zero_count > 0){
        //     int unit = even_count - zero_count;
        //     int hun = length - zero_count;
        //     int ten = length - 2;
        //     System.out.print(hun + " " + ten + " " + unit);
        //     return hun * ten * unit;
        // }
        // // zero and distinct <3
        // if(distinct_count < 3 && zero_count > 0){
        //     int unit = even_count - zero_count;
        //     int hun = length - zero_count - 1;
        //     int ten = length - 2;
        //     System.out.print(hun + " " + ten + " " + unit);
        //     return hun * ten * unit;
        // }
        // return res;
        
        int[] freq = new int[10];
        // Count occurrences of each digit
        for (int digit : digits) {
            freq[digit]++;
        }
        int res = 0;
        // Choose hundreds digit
        for (int h = 1; h <= 9; h++) {
            if (freq[h] == 0) continue;
            freq[h]--;
            // Choose tens digit
            for (int t = 0; t <= 9; t++) {
                if (freq[t] == 0) continue;
                freq[t]--;
                // Choose units digit - must be even
                for (int u = 0; u <= 8; u += 2) {
                    if (freq[u] == 0) continue;
                    res++;
                }
                freq[t]++;
            }
            freq[h]++;
        }
        return res;
    }
}