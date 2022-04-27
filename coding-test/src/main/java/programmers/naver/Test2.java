package programmers.naver;

public class Test2 {

    public static void main(String[] args) {
        int[][] maps = {{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19},
                {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29}, {39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};
        System.out.println(Solution.solution(maps, 19, 6));
    }

    static class Solution {
        public static int solution(int[][] maps, int p, int r) {
            int max = 0;
            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[0].length; j++) {
                    int candidate = clearNumbersByRange(maps, p, r, i, j);
                    if (candidate > max) {
                        max = candidate;
                    }
                }
            }
            return max;
        }

        private static int clearNumbersByRange(int[][] maps, int p, int r, int x, int y) {

            int clearNumbers = 0;
            /**
             * 4가지
             * x - 2, y - 2
             * x - 2, y - 1
             * x - 1, y - 2
             * x - 1, y - 1
             * x = 5, y = 4 => 4 , 3
             * r = 8 / 2 =. 4
             * r = 6 / 2 => 3 -1 => 2
             * r = 4 / 2 => 2 -1 => 1
             * r = 2 / 2 => 1 -1 => 0
             */

            int row, col, blue, yellow;
            // 1사분면 파란색
            row = x - 2;
            col = y - 1;
            blue = r / 2;
            for (int i = 0; i < blue; i++) {
                clearNumbers += clearNumbers(maps, p / 2, row - i, col + (blue - 1 - i));
            }
            // 1사분면 노란색
            yellow = blue - 1;
            for (int j = 1; j <= yellow; j++) {
                for (int i = 0; i < j; i++) {
                    clearNumbers += clearNumbers(maps, p, row - i, col + (j - 1 - i));
                }
            }

            // 2사분면 파란색
            row = x - 2;
            col = y - 2;
            blue = r / 2;
            for (int i = 0; i < blue; i++) {
                clearNumbers += clearNumbers(maps, p / 2, row - i, col - (blue - 1 - i));
            }
            // 2사분면 노란색
            yellow = blue - 1;
            for (int j = 1; j <= yellow; j++) {
                for (int i = 0; i < j; i++) {
                    clearNumbers += clearNumbers(maps, p, row - i, col - (j - 1 - i));
                }
            }

            // 3사분면 파란색
            row = x - 1;
            col = y - 2;
            blue = r / 2;
            for (int i = 0; i < blue; i++) {
                clearNumbers += clearNumbers(maps, p / 2, row + i, col - (blue - 1 - i));
            }
            // 3사분면 노란색
            yellow = blue - 1;
            for (int j = 1; j <= yellow; j++) {
                for (int i = 0; i < j; i++) {
                    clearNumbers += clearNumbers(maps, p, row + i, col - (j - 1 - i));
                }
            }

            // 4사분면 파란색
            row = x - 1;
            col = y - 1;
            blue = r / 2;
            for (int i = 0; i < blue; i++) {
                clearNumbers += clearNumbers(maps, p / 2, row + i, col + blue - 1 - i);
            }
            // 4사분면 노란색
            yellow = blue - 1;
            for (int j = 1; j <= yellow; j++) {
                for (int i = 0; i < j; i++) {
                    clearNumbers += clearNumbers(maps, p, row + i, col + j - 1 - i);
                }
            }



            return clearNumbers;

        }

        private static int clearNumbers(int[][] maps, int p, int row, int col) {
            if (row < 0 || col < 0 || row >= maps.length || col >= maps[0].length) {
                return 0;
            }

            if (maps[row][col] > p) {
                return 0;
            }

            return 1;
        }
    }
}
