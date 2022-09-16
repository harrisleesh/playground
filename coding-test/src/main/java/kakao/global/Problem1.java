package kakao.global;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem1 {
    public static void main(String[] args) {

        List<String> ing = new ArrayList<>();
    }
    public static int solution(List<String> ingredients, int startIndex, String target){
        for(int i = 0; i <= ingredients.size(); i++) {
            if(findByDistance(ingredients, startIndex, target, i)){
                return i;
            }
        }
        return ingredients.size();
    }

    private static boolean findByDistance(List<String> ingredients, int startIndex, String target, int distance) {
        if (distance == 0) {
            return ingredients.get(startIndex).equals(target);
        }
        int left = startIndex - distance;
        if(left < 0){
            left = ingredients.size() + left;
        }
        int right = startIndex + distance;
        if(right >= ingredients.size()){
            right = right - ingredients.size();
        }
        if(ingredients.get(left).equals(target)) {
            return true;
        }

        if(ingredients.get(right).equals(target)) {
            return true;
        }
        return false;
    }
}
