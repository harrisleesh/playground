package programmers;

import java.util.Arrays;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};
        Arrays.sort(arr);
        for (String el:arr
             ) {

            System.out.println(el);
        }

//        Solution.solution({"119", "97674223", "1195524421"});
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
