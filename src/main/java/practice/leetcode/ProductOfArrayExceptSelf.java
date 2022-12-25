package practice.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
//        test(new int[]{1, 2, 3, 4});
        test(new int[]{-1, 1, 0, -3, 3});
    }

    private static void test(int[] ints) {
        System.out.println(Arrays.asList(productExceptSelf(ints)));
    }

    public static Integer[] productExceptSelf(int[] nums) {
        Integer[] result = new Integer[nums.length];
        int[] reverse = reverseArray(nums);

        Integer[] left = new Integer[nums.length];
        Integer[] right = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = getPreviousProductExceptIdx(nums, left, i);
            right[i] = getPreviousProductExceptIdx(reverse, right, i);
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[nums.length - i - 1];
        }

        return result;
    }

    private static int[] reverseArray(int[] nums) {
        int[] rev = new int[nums.length];
        for (int i = nums.length; i > 0; i--) {
            rev[nums.length - i] = nums[i - 1];
        }
        return rev;
    }

    private static Integer getPreviousProductExceptIdx(int[] nums, Integer[] arr, int idx) {
        if (idx > 0) {
            return (nums[idx - 1] * arr[idx - 1]);
        }
        return 1;
    }
}
