package leetcode;

public class ReverseInteger {
    //7. Reverse Integer
    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    https://leetcode.com/problems/reverse-integer/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
//        System.out.println(solution.reverse(-123));

    }

    static class Solution {
        public int reverse(int x) {
            boolean minus = false;
            Long xLong = (long)x;
            String s = String.valueOf(xLong);
            System.out.println(s);
            if (xLong < 0) {
                minus = true;
                s = String.valueOf(xLong * -1);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int reverseIndex = s.length() - i - 1;
                char c = s.charAt(reverseIndex);
                sb.append(c);
            }
            if (minus) {
                sb.insert(0, '-');
            }
            if (Long.parseLong(sb.toString()) < Integer.MIN_VALUE ||
                    Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
                return 0;
            }

            return Integer.parseInt(sb.toString());
        }
    }
}
