package kurly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splits = input.split(" ");
        int start = Integer.parseInt(splits[0]);
        int end = Integer.parseInt(splits[1]);

        int maxCount = 0;
        for (int i = start; i <= end; i++) {
            maxCount = Math.max(maxCount, twoWayCalculate(i));
        }

        System.out.println(maxCount);
    }

    private static int twoWayCalculate(int i) {
        int counts = 1;
        int number = i;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            counts++;
        }
        return counts;
    }
}
