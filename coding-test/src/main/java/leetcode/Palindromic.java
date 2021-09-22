package leetcode;

public class Palindromic {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            // 1, 3, 5, 7 순서로 스트링을 순회한다.
            int length = s.length();
            while (length > 0) {
                for (int i = 0; i + length <= s.length(); i++) {
                    if (checkPalindrome(s.substring(i, length+i))) {
                        return s.substring(i, length + i);
                    }

                }
                length--;
            }
            return "";
        }

        private boolean checkPalindrome(String substring) {
            if (substring.length() == 1) {
                return true;
            }
            int halfLength = substring.length() / 2;
            for (int i = 0; i < halfLength; i++) {
                if (substring.charAt(i) != substring.charAt(substring.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
