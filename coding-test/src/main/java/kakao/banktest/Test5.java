package kakao.banktest;

public class Test5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {5, 3, 7, 9, 5, 2, 4, 9, 10, 6};
        int[] prices = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        solution.solution(prices);
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = 0;
            }
            for (int i = 0; i < prices.length; i++) {
                int number = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if(number < prices[j]){
                        answer[i]++;
                    }
                }
            }
            return answer;
        }
    }
}
