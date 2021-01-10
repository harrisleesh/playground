package socar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SocarOne {
    public static void main(String[] args) {
        String[] input = {"10 18 23 33 (15) 29 45", "42 (5) 45 32 15 23 12", "19 6 12 16 35 34 (17)", "(15) 23 26 21 20 37 12", "15 20 39 9 (18) 5 12", "18 (20) 11 5 22 21 25", "42 44 23 8 5 22 (20)"};
        Solution solution = new Solution();
        solution.solution(input);
//        String test = "(15)";
//        System.out.println(test.substring(test.indexOf("(") + 1, test.indexOf(")")));

    }

    static class Solution {
        public String solution(String[] lottos) {
            int[] basicLottos = new int[46];
            int[] bonusLottos = new int[46];
            for (String lotto : lottos) {
                String[] elems = lotto.split(" ");
                for (String elem : elems) {
                    if (elem.startsWith("(")) {
                        bonusLottos[Integer.parseInt(elem.substring(elem.indexOf("(") + 1, elem.indexOf(")")))]++;
                    } else {
                        basicLottos[Integer.parseInt(elem)]++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            List<Integer> topSix = new ArrayList<>();
            int basicNum = 0;
            int bonusNum = 0;
            for(int i = 7; i >0; i--){
                for (int j = 0 ; j < 46; j++) {
                    if(basicNum == 6)
                        break;
                    if(basicLottos[j] == i){
                        basicNum++;
                        topSix.add(j);
                    }
                }
            }
            for(int i = 7; i >0; i--){
                for (int j = 1 ; j < 46; j++) {
                    if(bonusNum != 0)
                        break;
                    if(bonusLottos[j] == i){
                        if(!topSix.contains(j)){
                            bonusNum = j;
                            topSix.add(j);
                            break;
                        }
                    }
                }
            }
            topSix.sort(Comparator.naturalOrder());

            for (Integer elem : topSix) {
                if(elem == bonusNum){
                    sb.append("(");
                    sb.append(elem);
                    sb.append(")");
                }
                else{
                    sb.append(elem);
                }
                sb.append(" ");
            }
            return sb.toString();
        }
    }

}
