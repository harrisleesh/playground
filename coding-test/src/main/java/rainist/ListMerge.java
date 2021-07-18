package rainist;

import java.util.*;
import java.util.stream.Collectors;

public class ListMerge {
    public static void main(String[] args) {
        System.out.println("start");
        int[][] list = {{1, 3}, {5, 8}, {4, 10}, {20, 25}};
        Solution solution = new Solution();
        int[][] answer = solution.solution(list);
        System.out.println(answer);
    }
    static class Solution{
        int[][] solution(int[][] list){
            //1. map에 시작점을 key, 끝점을 value로 insert
            //2. Map의 keyset을 가져온다, sorting한다.
            //3. stack을 준비한다.
            //4. stack이 비었으면 insert
            //5. stack에 값이 있으면 pop -> 이전 value랑 현재 value를 비교
            //6. 현재 value가 더 작거나 같으면 이전 값을 stack에 push 하고 continue
            //7. 현재 value가 더 크면 key값 비교 -> key가 같으면 현재 값을 stack에 insert
            //8. key가 다르면 둘다 인서트
            Map<Integer, Integer> startEndMap = new HashMap<>();
            for (int[] ints : list) {
                startEndMap.put(ints[0], ints[1]);
            }
            Set<Integer> integers = startEndMap.keySet();
            List<Integer> collect = startEndMap.keySet().stream().sorted().collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println("integer = " + integer);
            }
            return list;
        }
    }
}
