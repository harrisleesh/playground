package programmers;

import java.util.HashSet;
import java.util.Set;

public class Demo1 {
    class Solution {
        public int[] solution(int[][] v) {
            int[] answer = {};
            Set<Integer> xSet = new HashSet<>();
            Set<Integer> ySet = new HashSet<>();

            for (int i = 0; i < v.length; i++) {
                int x = v[i][0];
                int y = v[i][1];
                if (xSet.contains(x)) {
                    xSet.remove(x);
                }
                else{
                    xSet.add(x);
                }

                if (ySet.contains(y)) {
                    ySet.remove(y);
                }
                else{
                    ySet.add(y);
                }
            }
            answer[0] = xSet.stream().findAny().get();
            answer[1] = ySet.stream().findAny().get();
            System.out.println("Hello Java");

            return answer;
        }
    }
}
