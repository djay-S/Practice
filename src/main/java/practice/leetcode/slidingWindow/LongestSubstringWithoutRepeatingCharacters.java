package practice.leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        test("abcabcbb", 3);
        test("bbbb", 1);
        test("pwwkew", 3);
        test("", 0);
        test("floccicaucinihilipilification", 6);
        test("macbook is fucking shit", 0);
    }

    private static void test(String s, int expected) {
        System.out.printf("Result: %d, Expected: %d.\n", lengthOfLongestSubstring(s), expected);
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int count = 0;

        Set<Character> set = new HashSet<>();

        while (left <= right && right < s.length()) {
            if (set.add(s.charAt(right))) {
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
            count = Math.max(count, set.size());
        }
        return count;
    }
}
