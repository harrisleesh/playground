package house;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {

    // 해당 숫자를 선택 했는지, 선택하지 않았는지를 표현해줄 배열.
    static boolean[] visited;
    static List<Integer> sums = new ArrayList<>();

    public static void main(String[] args) {
        // 아무것도 선택하지 않는 경우부터 시작한다.
        // 홀수만 있을 때 는 1, 4, 9, 16
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        List<Integer> numbers = Arrays.stream(arr).boxed()
                .collect(Collectors.toList());

//        visited = new boolean[arr.length];
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1; j <= arr.length ; j++){
                // i ~ j 합을 구한다.
//                int sum = numbers.subList(i, j).stream()
//                        .mapToInt(Integer::intValue)
//                        .sum();
//                if (sum % 2 == 1) {
//                    answer ++;
//                }
                long count = numbers.subList(i, j).stream()
                        .filter(integer -> integer % 2 == 1)
                        .count();
                if (count % 2 == 1) {
                    answer ++;
                }
            }
        }

        System.out.println(answer);
//        powerSet(arr,0);
//        System.out.println(sums);
//        System.out.println(sums.size());
    }

    private static void powerSet(int[] arr, int count) {
        // 3개의 숫자에 대한 선택을 완료 하였다면, 선택된 숫자들을 출력한다.
        // 선택된 각 숫자들은 대상 배열의 '부분 집합'이다!
        if (count == arr.length) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                // 숫자가 선택 되었다면 출력한다.
                if (visited[i]) {
//                    System.out.print(arr[i] + " ");
                    sum += arr[i];
                }
            }
//            System.out.println();
            if (sum % 2 == 1) {
                sums.add(sum);
            }
            return;
        }

        // 해당 숫자를 선택하고 재귀를 진행한다.
        visited[count] = true;
        powerSet(arr, count + 1);
        // 해당 숫자를 선택하지 않고 재귀를 진행한다.
        visited[count] = false;
        powerSet(arr, count + 1);
    }
}
