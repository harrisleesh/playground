package hash;

import java.util.Arrays;

public class PhoneNumberList {
    
    public static void main(String[] args) {
        String[] phone_book = {"223", "97674223", "1195524421"};
        System.out.println( Solution.solution(phone_book));
    }
    
    static class Solution {
        public static boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);
            String previousNumber = " ";
            for (String string : phone_book) {
                if(string.startsWith(previousNumber))
                    return false;
                previousNumber = string;
            }
            return true;
        }
    }
}
