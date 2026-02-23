class Solution {
    public int compress(char[] chars) {
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i<chars.length;i++){
        //     char ch = chars[i];
        //     map.put(ch, map.getOrDefault(ch,0) + 1);
        // }
        // int i = 0;
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     chars[i] = entry.getKey();      
        //     chars[i + 1] = (char)(entry.getValue() + '0');
        //     i += 2;
        // }
        // return chars.length;
        int write = 0;
        int read = 0;
        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }
            chars[write++] = current;
            if (count > 1) {
                String num = String.valueOf(count);
                for (char c : num.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        System.out.println(chars);
        return write;
    }
}