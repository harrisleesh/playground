package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int windowSize = Integer.parseInt(input);
        List<Long> streams = new ArrayList<>();
        long max = Long.MIN_VALUE;
        int maxPointer = 0;
        for (int i = 0; i < windowSize; i++) {
            long item = Long.parseLong(br.readLine());
            if (item > max) {
                max = item;
                maxPointer = i;
            }
            streams.add(item);
        }
        SlidingWindow slidingWindow = new SlidingWindow(streams, max, maxPointer);
        System.out.println(slidingWindow.getMax());

        /*
        시간복잡도
        슬라이딩 한번 (addItem) : O(WindowSize)
        아이템의 갯수만큼 슬라이딩(addItem) : O(WindowSize * itemSize)
         */
        while (true) {
            String s = br.readLine();
            if (s.isEmpty()) break;
            long item = Long.parseLong(s);
            slidingWindow.addItem(item);
            System.out.println(slidingWindow.getMax());
        }
    }

    static class SlidingWindow{
        private List<Long> streams;
        private long max;
        private int maxPointer;
        private int leftPointer = 0;

        public SlidingWindow(List<Long> streams, long max, int maxPointer) {
            this.streams = streams;
            this.max = max;
            this.maxPointer = maxPointer;
        }

        public long getMax() {
            return max;
        }

        public void addItem(Long item){
            leftPointer++;

            streams.add(item);
            if (item > max) {
                max = item;
                maxPointer = streams.size() - 1;
            }
            if (leftPointer > maxPointer) {
                this.calculateMax();
            }
        }

        private void calculateMax() {
            max = Long.MIN_VALUE;
            for (int i = leftPointer; i < streams.size(); i++) {
                Long item = streams.get(i);
                if (item > max) {
                    max = item;
                    maxPointer = i;
                }
            }
        }
    }
}
