package kakao.banktest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] T = {5,8,3,7,10,5,4};
        int[][]R = {{1,2},{2,4},{1,4},{6,5},{3,5},{4,6}};
        int k = 5;
        System.out.println(solution.solution(T, R, k));
    }

    static class Solution{

        int[] T2 = {5,8,3,7,10,5,4};
        int answer2 = 0;
        public int solution(int[] T, int[][] R, int k) {
            int answer = 0;
            List<int[]> R2 = Arrays.stream(R).collect(Collectors.toList());
            if(R2.size() == 0)
                return 0;
            int ret = findRunningTime(R2, k);
            answer2 += ret;
            return answer2;
        }

        private int findRunningTime(List<int[]> R, int k) {
            List<int[]> R2 = R.stream().filter(r -> r[1] == k).collect(Collectors.toList());
            if(R2.size() == 0){
                int res = T2[k-1];
                T2[k-1] = 0;
                return res;
            }
            int max = 0;
            for (int[] el: R2) {
                max = Math.max(max, findRunningTime(R, el[0]));
            }
            answer2 += max;
            return T2[k-1];
        }
    }
}
