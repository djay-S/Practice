package practice.leetcode.arraysNhashing;

import java.util.*;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        test(new int[]{100,4,200,1,3,2}, 4);
        test(new int[]{0,3,7,2,5,8,4,6,0,1}, 9);
        test(new int[]{1}, 1);
        test(new int[]{}, 0);
        test(new int[]{100,2002}, 1);
        test(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}, 7);
        test(new int[]{1,2,0,1}, 3);
    }

    private static void test(int[] ints, int expected) {
        System.out.printf("Result: %d, Expected: %d\n", longestConsecutive(ints), expected);
    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        int ans = 1, count = 1;
        Arrays.sort(nums);

        for (int i = 0;i < list.size() - 1; i++) {
            if (list.get(i) - list.get(i+1) == -1) {
                count++;
            }
            else {
                count = 1;
            }
            if (ans < count) {
                ans = count;
            }
        }

        return ans;
    }
}
