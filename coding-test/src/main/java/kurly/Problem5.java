package kurly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Problem5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        /**
         1. 화이트와 블랙을 구분한다.
         2. 각자 내림차순 정렬
         3. 둘 중 큰 수부터 차례로 선택한다.
         */
        int containerCounts = Integer.parseInt(input);
        List<Integer> blackList = new ArrayList<>();
        List<Integer> whiteList = new ArrayList<>();
        for (int i = 0; i < containerCounts; i++) {
            int containerSizeColor = Integer.parseInt(br.readLine());
            if (containerSizeColor > 0) {
                blackList.add(containerSizeColor);
            } else {
                whiteList.add(containerSizeColor * -1);
            }
        }
        blackList.sort((o1, o2) -> o1 < o2 ? 1 : o1 > o2 ? -1 : 0);
        whiteList.sort((o1, o2) -> o1 < o2 ? 1 : o1 > o2 ? -1 : 0);

        if (blackList.size() == 0 || whiteList.size() == 0) {
            System.out.println(1);
            return;
        }

        int size = 0;
        int turn = blackList.get(0) > whiteList.get(0) ? 1 : -1;
        int lastContainerSize = 1000000;
        for (int i = 0; i < containerCounts; i++) {
            Optional<Integer> container;
            if (turn == 1) {
                container = getSmallerContainer(blackList, lastContainerSize);
            } else {
                container = getSmallerContainer(whiteList, lastContainerSize);
            }
            if (container.isPresent()) {
                turn *= -1;
                lastContainerSize = container.get();
                size++;
            }
        }

        System.out.println(size);
    }

    private static Optional<Integer> getSmallerContainer(List<Integer> containers, int i) {
        return containers.stream()
                .filter(cont -> cont < i)
                .findFirst();
    }
}
