package kakao.banktest;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] v = {{1, 4}, {3, 4}, {3, 10}};
        System.out.println("answer");
        System.out.println(solution.solution(v)[0]);
        System.out.println(solution.solution(v)[1]);

    }
    static class Solution {
        public int[] solution(int[][] v) {
            int[] answer = {};
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int[] arr: v) {

                if(row.contains(arr[0])){
                    row.remove(arr[0]);
                }
                else{
                    row.add(arr[0]);
                }
                if(col.contains(arr[1]))
                {
                    col.remove(arr[1]);
                }
                else{
                    col.add(arr[1]);
                }
            }
            Integer x = row.stream().findFirst().orElseThrow(() -> new IllegalArgumentException());
            Integer y = col.stream().findFirst().orElseThrow(() -> new IllegalArgumentException());
            answer = new int[]{x.intValue(), y.intValue()};
            return answer;
        }
    }
}
