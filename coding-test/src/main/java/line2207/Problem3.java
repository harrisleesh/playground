package line2207;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(solution(10, new int[]{8, 4, 2, 5, 3, 7}));
        System.out.println(solution(10, new int[]{1,2,3,3,3,8}));
    }
    public static int solution(int n, int[] bankbook) {
        int answer = 0;

        List<Integer> bankbookList = new ArrayList<>();
        for (int money : bankbook) {
            bankbookList.add(money);
        }
        bankbookList.sort(Integer::compareTo);

        answer = recursion(n,0, bankbookList);

        return answer;
    }

    public static int recursion(int n, int bankSize, List<Integer> bankbookList) {
        if (bankSize >= n) {
            return n;
        }
        if (bankbookList.size() == 1) {
            return bankSize + 1;
        }

        List<Integer> subList = bankbookList.subList(1, bankbookList.size());
        int minBankSize = recursion(n, bankSize + 1, subList);
        for (int i = 0; i < subList.size(); i++) {
            if(subList.get(i) + bankbookList.get(0) <= n) {
                List<Integer> copyList = new ArrayList<>(List.copyOf(subList));
                copyList.set(i, subList.get(i) + bankbookList.get(0));
                minBankSize = Math.min(minBankSize, recursion(n, bankSize, copyList));
            }
        }
        return Math.min(minBankSize, bankSize + bankbookList.size());
    }

    // 2 - 0
    // 2 - 3 => 5
    // 2 - 4 => 6
    // 2 - 5 => 7
    // 2 - 7 => 9
    // 2 - 8 => 10
}
