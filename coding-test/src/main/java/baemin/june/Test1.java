package baemin.june;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arg = {1, 1, 2, 0};
        int[] arg = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] answers = solution.solution(arg);

        for (int answer: answers) {
            System.out.println(answer);
        }
    }
    static class Solution {
        private Set<Integer> changedIndexSet = new HashSet<>();
        public int[] solution(int[] black_caps) {
            int lastIndex = black_caps.length;
            int[] answer = new int[lastIndex];

            // 1. 양끝에서 0인지 1인지에 다라 그 옆사람의 색깔을 정한다.
            // 2. 2개로 대답한 사람들의 양 옆의 검정색을 세팅한다.
            // 3. 0으로 응답한 사람들의 양 옆에 흰색을 세팅한다.
            // 4. 1로 응답
            // 4.1 한쪽만 색이 결정되어있으면 찾을 수 있다.
            // 4.2 한쪽도 색이 결정되어있지 않으면 찾을 수 없다.

            // 1.
            if (black_caps[0] == 1) {
                answer[1] = 1;
            } else{
                answer[1] = 2;
            }

            if (black_caps[lastIndex - 1] == 1) {
                answer[lastIndex - 2] = 1;
            } else{
                answer[lastIndex - 2] = 2;
            }

            // 2.
            for (int i = 1; i < lastIndex - 1; i++) {
                if (black_caps[i] == 0) {
                    colorWhiteNextTo(i, answer);
                }
                if (black_caps[i] == 2) {
                    colorBlackNextTo(i, answer);
                }
            }
            for (int i = 1; i < lastIndex - 1; i++) {
                if (black_caps[i] == 1) {
                    colorBlackAndWhiteNextTo(i, answer);
                }
            }

           return answer;
        }

        private void colorWhiteNextTo(int i, int[] answer) {
            answer[i - 1] = 2;
            answer[i + 1] = 2;
        }

        private void colorBlackNextTo(int i, int[] answer) {
            answer[i - 1] = 1;
            answer[i + 1] = 1;
        }

        private void colorBlackAndWhiteNextTo(int i, int[] answer) {
            boolean isChanged = false;
            int changedIndex = 0;
            //양 옆이 둘다 0일때는 알 수 없다.
            if (answer[i - 1] == 1 && answer[i + 1] == 0) {
                answer[i + 1] = 2;
                isChanged = true;
                changedIndex = i + 2;
            }
            else if (answer[i - 1] == 2 && answer[i + 1] == 0) {
                answer[i + 1] = 1;
                isChanged = true;
                changedIndex = i + 2;
            }
            else if (answer[i + 1] == 1 && answer[i - 1] == 0) {
                answer[i - 1] = 2;
                isChanged = true;
                changedIndex = i - 2;
            }
            else if (answer[i + 1] == 2 && answer[i - 1] == 0) {
                answer[i - 1] = 1;
                isChanged = true;
                changedIndex = i - 2;
            }
            if (isChanged) {
                if(!(changedIndex <= 0 || changedIndex >= answer.length - 1)) {
//                    changedIndexSet.add(changedIndex);
                    colorBlackAndWhiteNextTo(changedIndex, answer);
                }
            }
        }
    }
}
