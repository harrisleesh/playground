package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MedianTwoSortedArrays {
    /*
    https://leetcode.com/problems/median-of-two-sorted-arrays/
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            nums1List.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
            nums1List.sort(Comparator.naturalOrder());
            if(nums1List.size() % 2 == 0){
                return (nums1List.get(nums1List.size() / 2 -1) + nums1List.get(nums1List.size() / 2 )) / 2.0;
            }
            return nums1List.get(nums1List.size() / 2);
        }
    }
}
