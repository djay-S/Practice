package practice.leetcode.binarySearch;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/binary-search/description/
public class BinarySearch {
    public static void main(String[] args) {
        test(new Integer[]{-1,0,3,5,9,12}, 9, 4);
        test(new Integer[]{-1,0,1,2}, 0, 1);
        test(new Integer[]{-1,0,3,5,9,12}, 2, -1);
        test(new Integer[]{-1,0,3,5,9,12}, 0, 1);
        test(new Integer[]{12}, 12, 0);
        test(new Integer[]{}, 2, -1);
    }

    private static void test(Integer[] nums, int target, int expected) {
        int myAnswer = search(nums, target);
        String finalAnswer = List.of(myAnswer).equals(List.of(expected)) ? "✅" : "❌";
        System.out.printf("Nums: %s, Target: %d, Result: %s, Expected: %s, Final: %s.\n", Arrays.asList(nums), target, Arrays.asList(myAnswer), Arrays.asList(expected), finalAnswer);
    }

    private static int search(Integer[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right ) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
