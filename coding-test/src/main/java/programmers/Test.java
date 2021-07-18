package programmers;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][]input = {{1, 4}, {3, 4}, {3, 10}};
        solution.solution(input);
    }
    static class Solution {
        public int[] solution(int[][] v) {
            Set<Integer> xSet = new HashSet<>();
            Set<Integer> ySet = new HashSet<>();

            for (int[] spot : v) {
                if(xSet.contains(spot[0])){
                    xSet.remove(spot[0]);
                }
                else{
                    xSet.add(spot[0]);
                }
                if(ySet.contains(spot[1])){
                    ySet.remove(spot[1]);
                }
                else{
                    ySet.add(spot[1]);
                }
            }
            Integer xValue = xSet.stream().findFirst().orElseThrow();
            Integer yVlaue = ySet.stream().findFirst().orElseThrow();
            int [] answer = {xValue, yVlaue};
            System.out.println("Hello Java");
            System.out.println(answer[0]);
            System.out.println(answer[1]);
            return answer;
        }
    }
}
