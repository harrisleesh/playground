package kakao;

import java.util.Stack;

public class PickupToySolution {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution solution = new Solution();
        int answer = solution.solution(board, moves);
        System.out.println(answer);
    }
    static class Solution{
        public int solution(int[][] board, int[] moves){
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for(int move : moves){
                for( int j = 0; j < board.length; j++){
                    if(board[j][move-1] != 0){
                        if(stack.isEmpty()){
                            stack.push(board[j][move-1]);
                            board[j][move-1] = 0;
                            break;
                        }
                        if(board[j][move-1] == stack.peek()){
                            stack.pop();
                            answer+=2;
                        } else{
                            stack.push(board[j][move-1]);
                        }
                        board[j][move-1] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
