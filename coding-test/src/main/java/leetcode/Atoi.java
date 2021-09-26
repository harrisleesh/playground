package leetcode;

public class Atoi {
    /*
    String to integer
    https://leetcode.com/problems/string-to-integer-atoi/
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));

    }

    static class Solution {
        public int myAtoi(String s) {
            String trimmedString = s.trim();
            boolean minus = false;
            String subString = trimmedString;
            if (trimmedString.charAt(0) == '-') {
                minus = true;
                subString = trimmedString.substring(1);
            } else if (trimmedString.charAt(0) == '+') {
                subString = trimmedString.substring(1);
            }

            for (int i = 0; i < subString.length(); i++) {
                char c = subString.charAt(i);
                if ('0' > c  || c > '9') {
                    System.out.println("not a number");

                }
            }
            return 0;
        }
    }
}
