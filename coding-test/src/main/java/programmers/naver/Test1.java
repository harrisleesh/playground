package programmers.naver;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {


        Solution solution = new Solution();
        int[][] testSet = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {3,4,5,3,4,5,3,4,5},
                {2,2,2,2,2,2,2,2,2}};
        int[] solution1 = Solution.solution(testSet);
        for (int sol : solution1) {
            System.out.println(sol);
        }
    }

    static class Solution {
        public static int[] solution(int[][] numbers) {
            int[] answer = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                answer[i] = isMagicNumbers(numbers[i]);
            }
            return answer;
        }

        private static int isMagicNumbers(int[] numbers) {
            boolean isMagic = true;
            //1. 등차 수열
            Arrays.sort(numbers);
            int diff = numbers[1] - numbers[0];
            for (int i = 0; i < numbers.length - 1; i++) {
                if(numbers[i + 1] - numbers[i] != diff){
                    isMagic = false;
                }
            }
            if (isMagic) {
                return 1;
            }
            //2. 모두 같은 수
            isMagic = true;
            int sameNumber = numbers[0];
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i] != sameNumber){
                    isMagic = false;
                }
            }
            if (isMagic) {
                return 1;
            }
            //3. 3개 단위로 같은수
            isMagic = true;
            for (int i = 0; i < numbers.length; i++) {
                if (i % 3 == 0) {
                    sameNumber = numbers[i];
                }
                if (numbers[i] != sameNumber) {
                    isMagic = false;
                }
            }
            if (isMagic) {
                return 1;
            }
            return 0;
        }
    }
}
