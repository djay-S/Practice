package practice.leetcode.twoPointers;

import java.util.*;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {
    public static void main(String[] args) {
        test(new int[] {-1,0,1,2,-1,-4}, List.of(List.of(-1,-1,2), List.of(-1,0,1)));
        test(new int[] {0,1,1}, List.of());
        test(new int[] {0,0,0}, List.of(List.of(0,0,0)));
        test(new int[] {-1,0,1}, List.of(List.of(-1,0,1)));
        test(new int[] {0,0,0,0}, List.of(List.of(0,0,0)));
    }

    private static void test(int[] nums, List<List<Integer>> expected) {
        System.out.printf("Result: %s, Expected: %s\n", threeSum(nums), expected);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
            int left = 1 + i;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums [right];

                if (sum > 0) {
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    list.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }

        return list;
    }

}
