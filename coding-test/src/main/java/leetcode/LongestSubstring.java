package leetcode;

public class LongestSubstring {
    /*
        https://leetcode.com/problems/longest-substring-without-repeating-characters/
        3. Longest Substring Without Repeating Characters
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            String subString = "";
            int maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                char charAt = s.charAt(i);
                int index = subString.indexOf(charAt);
                if (index == -1) {
                    subString += charAt;
                } else {
                    maxLength = Math.max(maxLength, subString.length());
                    subString = subString.substring(index + 1) + charAt;
                }
            }
            maxLength = Math.max(maxLength, subString.length());
            return maxLength;
        }
    }
}
