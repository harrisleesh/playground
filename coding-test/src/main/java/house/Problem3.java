package house;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    static char[][] keyBoard = {
            {
                    'A', 'B', 'C', 'D', 'E', 'F'
            },
            {
                    'G', 'H', 'I', 'J', 'K', 'L'
            },
            {
                    'M', 'N', 'O', 'P', 'Q', 'R'
            },
            {
                    'S', 'T', 'U', 'V', 'W', 'X'
            },
            {
                    'Y', 'Z'
            }
    };

    static Map<Character, int[]> keyBoardPositionMap = new HashMap<>();


    public static void main(String[] args) {
        initKeyBoardPositionMap();
        String param0 = "AUNU";
        int cost = Integer.MAX_VALUE;
        for (int i = 1; i < param0.length(); i++) {
            cost = Math.min(cost, findCostWith(param0, i));
        }

        System.out.println(cost);
    }

    private static int findCostWith(String param0, int finger2AppearTime) {
        char finger1 = param0.charAt(0);
        char finger2 = param0.charAt(0);
        int cost = 0;


        for (int i = 1; i < param0.length(); i++) {
            if (finger2AppearTime == i) {
                finger2 = param0.charAt(i);
            } else if(finger2AppearTime > i){
                cost += findDistance(finger1, param0.charAt(i));
                finger1 = param0.charAt(i);
            } else {
                int distanceFinger1 = findDistance(finger1, param0.charAt(i));
                int distanceFinger2 = findDistance(finger2, param0.charAt(i));
                if (distanceFinger1 > distanceFinger2) {
                    cost += findDistance(finger2, param0.charAt(i));
                    finger2 = param0.charAt(i);
                } else {
                    cost += findDistance(finger1, param0.charAt(i));
                    finger1 = param0.charAt(i);
                }
            }
        }
        return cost;
    }

    private static int findDistance(char first, char second) {
        int[] firstPosition = keyBoardPositionMap.get(first);
        int[] secondPosition = keyBoardPositionMap.get(second);
        int xDistance = Math.abs(firstPosition[0] - secondPosition[0]);
        int yDistance = Math.abs(firstPosition[1] - secondPosition[1]);
        return xDistance + yDistance;
    }

    private static void initKeyBoardPositionMap() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                keyBoardPositionMap.put(keyBoard[i][j], new int[]{i, j});
            }
        }
        keyBoardPositionMap.put(keyBoard[4][0], new int[]{4, 0});
        keyBoardPositionMap.put(keyBoard[4][1], new int[]{4, 1});
    }


}
