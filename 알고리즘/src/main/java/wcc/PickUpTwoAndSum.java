package wcc;

import java.util.HashSet;
import java.util.Set;

//월간 코드 챌린지 시즌1
//두개 뽑아서 더하기
//https://programmers.co.kr/learn/courses/30/lessons/68644
public class PickUpTwoAndSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int[] solution1 = solution.solution(numbers);
        System.out.println(solution1);
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> sums = new HashSet<>();
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    sums.add(numbers[i] + numbers[j]);
                }
            }
            int[] answer = sums.stream()
                    .sorted()
                    .mapToInt(Integer::intValue)
                    .toArray();
            return answer;
        }
    }
}
