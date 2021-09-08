package kakao.banktest;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        solution.solution(needs, 2);
    }

    static class Solution {
        int max = 0;
        public int solution(int[][] needs, int r) {
            int answer = 0;
            boolean[] visited = new boolean[needs[0].length];

            comb(needs, needs[0].length, visited, 0, r);
            System.out.println(max);
            answer = max;
            return answer;
        }
        public void comb(int[][]needs, int length, boolean[] visited, int start, int r) {
            if(r == 0) {
                cal(needs, length, visited);
                return;
            } else {
                for(int i = start; i < length; i++) {
                    visited[i] = true;
                    comb(needs, length, visited, i + 1, r - 1);
                    visited[i] = false;
                }
            }
        }
        public void cal(int[][] needs, int length, boolean[] visited) {
            Set<Integer> ints = new HashSet<>();
            for (int i = 0; i < length; i++) {
                if (visited[i] == false) {
                    System.out.print(i + " ");
                    ints.add(i);
                }
            }
            int match = 0;
            for(int[] need : needs) {
                if(ints.stream().allMatch(i -> need[i] == 0)){
                    match++;
                }
            }
            max = Math.max(match, max);
            System.out.println();
        }
    }
}
