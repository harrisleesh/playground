package line2207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        String[] splits = input.split(" ");
        int count = splits.length;

        int[] numbers = new int[count];
        boolean[] trustValue = new boolean[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(splits[i]);
        }

        for (int i = 0; i < count; i++) {
            int target = numbers[i];
            for (int j = i - 2; j < i; j++) {
                if (j >= 0) {
                    if (isTrustValue(target, numbers[j])) {
                        trustValue[i] = true;
                    }
                }
            }

            for (int j = i + 1; j <= i + 2; j++) {
                if (j < count) {
                    if (isTrustValue(target, numbers[j])) {
                        trustValue[i] = true;
                    }
                }
            }
        }

        int sum = 0;
        int trustCount = 0;
        for (int i = 0; i < count; i++) {
            if (trustValue[i]) {
                trustCount++;
                sum += numbers[i];
            }
        }
        if (trustCount == 0) {
            System.out.println("ERROR");
            return;
        }
        System.out.println(sum / trustCount);
        //
        // 1 2 3 100 100 1 \
        // 10(x) 16(x) 13 12 15 14 12
    }

    private static boolean isTrustValue(int target, int number) {
        if (target < -200 || target > 200) {
            return false;
        }

        if (Math.abs(target - number) >= 3) {
            return false;
        }
        return true;
    }
}
