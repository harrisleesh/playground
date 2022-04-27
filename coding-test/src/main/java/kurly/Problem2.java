package kurly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        /*
        1. 전자렌지 돌리는 시간을 짧은 순서로 정렬한다.
           ** 전자렌지 돌리는 시간은 시작 부터 해당 시간까지임
        2. 햄버거 먹는 시간을 긴 순서로 정렬한다.
        3. 1.2 순서대로 페어를 짓는다. 그중에 MAX 를 구한다.
        */

        int burgerCounts = Integer.parseInt(input);
        List<Integer> eatingTimeList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted((o1, o2) -> o1 < o2 ? 1 : o1 > o2 ? -1 : 0)
                .collect(Collectors.toList());

        List<Integer> microwaveTime = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted((o1, o2) -> o1 > o2 ? 1 : o1 < o2 ? -1 : 0)
                .collect(Collectors.toList());
        int minimumTime = 0;

        int microwaveTimeAcc = 0;
        for (int i = 0; i < burgerCounts; i++) {
            microwaveTimeAcc += microwaveTime.get(i);
            int eatingTimeAcc = eatingTimeList.get(i);
            minimumTime = Math.max(microwaveTimeAcc + eatingTimeAcc, minimumTime);
        }

        System.out.println(minimumTime);


    }
}
