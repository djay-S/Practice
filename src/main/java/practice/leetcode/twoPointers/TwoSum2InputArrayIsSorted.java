package practice.leetcode.twoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        test(new int[] {2,7,11,15}, 9, new Integer[]{1, 2});
        test(new int[] {2,3,4}, 6, new Integer[]{1, 3});
        test(new int[] {-1, 0}, -1, new Integer[]{1, 2});
        test(new int[] {1,7,11,15,23,45,83,100,104}, 90, new Integer[]{2, 7});
    }

    private static void test(int[] numbers, int target, Integer[] expected) {
        System.out.printf("Result: %s, Expected: %s\n", Arrays.asList(twoSum(numbers, target)), Arrays.asList(expected));
    }

    public static Integer[] twoSum(int[] numbers, int target) {
        int diff = target - numbers[0];
        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr < numbers.length && rightPtr >= 0 && leftPtr < rightPtr) {
            if (diff < numbers[rightPtr]) {
                rightPtr--;
            }
            if (diff > numbers[rightPtr]) {
                leftPtr++;
                diff = target - numbers[leftPtr];
            }
            if (diff == numbers[rightPtr]) {
                return new Integer[]{leftPtr + 1, rightPtr + 1};
            }
        }
        return new Integer[]{};
    }
}
