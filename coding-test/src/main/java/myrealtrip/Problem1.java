package myrealtrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] logs = new String[n];
        for (int i = 0; i < n; i++) {
            logs[i] = scanner.nextLine().trim();
        }

        List<String> summary = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n) {
                if (i == n - 1) {
                    insertIntoSummary(summary, logs[i], count);
                    break;
                }
                if (logs[i].equals(logs[i + 1])) {
                    count++;
                    i++;
                } else {
                    insertIntoSummary(summary, logs[i], count);
                    break;
                }
            }
        }

        for (String sum :
                summary) {
            System.out.println(sum);
        }
    }


    private static void insertIntoSummary(List<String> summary, String log, int count) {
        if (count > 1) {
            summary.add(log + " (" + count + ")");
        } else {
            summary.add(log);
        }
    }
}
