package practice.leetcode.arraysNhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/submissions/341390154/
public class TwoSum {
    public static void main(String[] args) {
        test(new int[] {2,7,11,15}, 9, new Integer[] {0, 1});
        test(new int[] {3,2,4}, 6, new Integer[] {1, 2});
        test(new int[] {3,3}, 6, new Integer[] {0, 1});
    }

    private static void test(int[] nums, int target, Integer[] expected) {
        System.out.printf("Result: %s, Expected: %s\n", Arrays.asList(twoSum(nums, target)), Arrays.asList(expected));
    }

    public static Integer[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new Integer[]{map.get(nums[i]), i};
            }
            int diff = target - nums[i];
            map.put(diff, i);
        }
        return new Integer[]{};
    }
}
