package programmers.naver;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(3, 6, 3));
        System.out.println(Solution.solution(10, 6, 5));
    }
    static class Solution {
        public static int solution(int n, int m, int k) {
            int answer = 0;

            answer = recursiveSolution(n, m, k);
            int mod = 1000007;
            return answer % mod;
        }

        private static int recursiveSolution(int n, int m, int k) {
            if (n > m) {
                return 0;
            }

            if (n == 1) {
                if(m > k){
                    return 0;
                }
                return 1;
            }

            int acc = 0;
            for (int i = 1; i <= k; i++) {
                acc += recursiveSolution(n - 1, m - i, k);
            }
            return acc;
        }
    }
}
