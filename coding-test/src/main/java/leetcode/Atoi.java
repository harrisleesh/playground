package leetcode;

public class Atoi {
    /*
    String to integer
    https://leetcode.com/problems/string-to-integer-atoi/
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("-42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));

    }

    static class Solution {
        public int myAtoi(String s) {
            String trimmedString = s.trim();
            boolean minus = false;
            String subString = trimmedString;
            if (trimmedString.length() == 0) {
                return 0;
            }
            if (trimmedString.charAt(0) == '-') {
                minus = true;
                subString = trimmedString.substring(1);
            } else if (trimmedString.charAt(0) == '+') {
                subString = trimmedString.substring(1);
            } else if (isNotNumber(trimmedString.charAt(0))) {
                return 0;
            }
            int lastIndex = subString.length();
            for (int i = 0; i < subString.length(); i++) {
                char c = subString.charAt(i);
                if (isNotNumber(c)) {
                    lastIndex = i;
                    break;
                }
            }
            if (lastIndex == 0) {
                return 0;
            }
            long parseLong = Long.parseLong(subString.substring(0, lastIndex));
            if(minus){
                parseLong = parseLong * -1;
            }
            if(parseLong > Integer.MAX_VALUE){
                parseLong = Integer.MAX_VALUE;
            }
            if(parseLong < Integer.MIN_VALUE){
                parseLong = Integer.MIN_VALUE;
            }
            return (int)parseLong;
        }

        private boolean isNotNumber(char c) {
            return '0' > c || c > '9';
        }
    }
}
