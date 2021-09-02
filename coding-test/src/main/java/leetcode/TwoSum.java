package leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

    }
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        public int[] twoSum2(int[] nums, int target) {
            int[] result = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if(map.containsKey(target - nums[i])){
                    result[1] = i;
                    result[0] = map.get(target - nums[i]);
                    return result;
                }
                map.put(nums[i], i);
            }
            return result;
        }
    }
}
