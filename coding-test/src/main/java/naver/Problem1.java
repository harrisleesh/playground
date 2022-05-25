package naver;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
//        int[][] recruits = {{1, 50}, {1, 60}, {3, 70}, {0, 65}, {2, 50}, {1, 90}};
//        int s1 = 2;
//        int s2 = 70;

//           result {1, 90}
//        int[][] recruits = {{0, 0}, {0, 0}, {0, 0}, {0, 3}, {1, 2}, {2, 0}, {2, 0}, {2, 1}};
//        int s1 = 2;
//        int s2 = 4;
//        result {2, 1}
//        int[][] recruits =   {{0, 0}, {0, 0}, {0, 0}, {2, 0}, {0, 2}, {1, 1}};
//        int s1 = 2;
//        int s2 =2;
//        result ={1, 1}
        int[][] recruits = {{0, 2}, {0, 3}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 3}, {3, 2}};
        int s1 = 2;
        int s2 = 3;
//        reuslt {2, 2}
        int[] solution = Solution.solution(recruits, s1, s2);
        System.out.println(solution[0] + ", "+ solution[1]);
    }

    public static class Solution{
        public static int[] solution(int[][] recruits, int s1, int s2) {
            // 0. 전체 개수 구하기
            // 1. junior 개수 구하기
            // 2. junior를 뺀 배열을 만들기 => 합이 제일 큰 순서로 정렬
            // 3. 전체개수 - junior = 남은개수, 남은개수 - junior 번째 배열부터 검색 시작
            // 4. 정답구하기
            int allCounts = recruits.length; //9
            List<int[]> recruitsList = new ArrayList<>();
            List<int[]> baseList = new ArrayList<>();
            Set<Integer> base1 = new HashSet<>();
            Set<Integer> base2 = new HashSet<>();

            for (int[] recruit : recruits) {
                base1.add(recruit[0]);
                base2.add(recruit[1]);
                recruitsList.add(recruit);
            }

            for (int x : base1) {
                for (int y : base2) {
                    baseList.add(new int[]{x, y});
                }
            }

            baseList.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] + o1[1] < o2[0] + o2[1] ? 1 : o1[0] + o1[1] > o2[0] + o2[1] ? -1 : //합이 같을 때
                            o1[0] < o2[0] ? 1 : o1[0] > o2[0] ? -1 : 0;
                }
            });

            // 하나 하나 뒤지면서 개수 구하기
            for (int i = 0; i < baseList.size(); i++) {
                int[] base = baseList.get(i);
                long expertCounts = getExpertCounts(recruitsList, base);
                long seniorCounts = getSeniorCounts(recruitsList, s1, s2, base);
                if (expertCounts > 0 && expertCounts < seniorCounts && seniorCounts < allCounts-seniorCounts-expertCounts) {
                    return base;
                }
            }

            int[] answer = {};
            return answer;
        }

        private static long getExpertCounts(List<int[]> recruits, int[] eBase ) {
            return recruits.stream()
                    .filter(recruit -> recruit[0] >= eBase[0] && recruit[1] >= eBase[1])
                    .count();
        }

        private static long getSeniorCounts(List<int[]> recruits, int s1, int s2, int[] eBase ) {
            return recruits.stream()
                    .filter(recruit -> recruit[0] < eBase[0] || recruit[1] < eBase[1])
                    .filter(recruit -> recruit[0] >= s1 || recruit[1] >= s2)
                    .count();
        }
    }
}
