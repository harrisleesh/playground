package programmers;

import java.util.*;
import java.util.function.IntBinaryOperator;
import static java.util.stream.Collectors.*;


public class Camouflage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}}));

        System.out.println(solution.solution(new String[][]{{"yellowhat", "headgear"}}));
    }

    public static class Solution {

        int solution(String[][] clothes) {
            Map<String, List<String>> clothMap = new HashMap<>();
            Arrays.stream(clothes)
                    .forEach(cloth -> {
                        if (clothMap.containsKey(cloth[1])) {
                            List<String> list = clothMap.get(cloth[1]);
                            ArrayList<String> newList = new ArrayList<>(list);
                            newList.add(cloth[0]);
                            clothMap.put(cloth[1], newList);
                        }
                        else{
                            clothMap.put(cloth[1], Arrays.asList(cloth[0]));
                        }
                    });
            int asInt = clothMap.values().stream()
                    .mapToInt(list -> list.size() + 1)
                    .reduce((a, b) -> a * b)
                    .getAsInt();

            return asInt-1;
        }
//        return Arrays.stream(clothes)
//                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//                .values()
//                    .stream()
//                    .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
