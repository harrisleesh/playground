package kakao;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2019 카카오 개발자 겨울 인턴쉽
//크레인 인형뽑기 게임
//https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
class PickupToy {


    static class Solution {
        public static Stack<Integer> baguni = new Stack<>();
        public static int pops = 0;

        public static void main(String[] args) {
            int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
            int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
            solution(board, moves);
            System.out.println(pops);

        }

        public static int solution(int[][] board, int[] moves) {
            List<List<Integer>> boardToList = new ArrayList<>();
            Arrays.stream(board).forEach(ints -> boardToList.add(
                    new ArrayList<Integer>(Arrays.stream(ints).boxed().collect(Collectors.toList()))));

            List<Queue<Integer>> boardQueue = new ArrayList<>();
            int boardWidth = boardToList.get(0).size();
            IntStream.range(0, boardWidth)
                    .forEach(i -> boardQueue.add(new ConcurrentLinkedDeque<>()));
            boardToList.stream().forEach(row ->
                    IntStream.range(0, row.size())
                            .filter(idx -> row.get(idx) != 0)
                            .forEach(idx -> boardQueue.get(idx).add(row.get(idx)))
            );

            IntStream.range(0, moves.length)
                    .forEach(idx -> queuePop(boardQueue, moves[idx] - 1));

            int answer = 0;
            return answer;
        }

        private static void queuePop(List<Queue<Integer>> boardQueue, int move) {
            Queue<Integer> queue = boardQueue.get(move);
            if (queue.peek() != null) {
                Integer toy = queue.remove();
                if (baguni.size() != 0) {
                    Integer toyInbaguni = baguni.pop();
                    if (toyInbaguni.equals(toy)) {
                        pops += 2;
                    } else {
                        baguni.add(toyInbaguni);
                        baguni.add(toy);
                    }
                } else {
                    baguni.add(toy);
                }
            }

        }
    }
}