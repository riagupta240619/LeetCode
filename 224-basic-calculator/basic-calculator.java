import java.util.*;

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        int result = 0;
        int sign = 1;   // +1 or -1

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // build number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }

            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }

            else if (ch == '(') {
                // save current state
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            else if (ch == ')') {
                result += sign * num;
                num = 0;

                result *= stack.pop(); // sign before bracket
                result += stack.pop(); // result before bracket
            }
        }

        return result + sign * num;
    }
}