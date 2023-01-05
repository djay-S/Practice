package practice.leetcode.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        test("ABAB", 2, 4);
        test("AABABBA", 1, 4);
        test("AACBBBA", 1, 4);
        test("AACBBBB", 1, 5);
        test("AACBBBB", 3, 7);
        test("BAAAB", 2, 5);
        test("Q", 3, 1);
    }

    private static void test(String s, int k, int expected) {
        int myAnswer = characterReplacement(s, k);
        String finalAnswer = myAnswer == expected ? "✅" : "❌";
        System.out.printf("String: %s, K: %d, Result: %d, Expected: %d, Final:%s.\n",s, k, myAnswer, expected, finalAnswer);
    }

    private static int characterReplacement(String s, int k) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            int count = 0;
            char chr = s.charAt(right);
            if (letterCountMap.containsKey(chr)) {
                count = letterCountMap.get(chr);
            }
            letterCountMap.put(chr, count + 1);

            while (right - left + 1 - Collections.max(letterCountMap.values()) > k) {
                letterCountMap.put(s.charAt(left), letterCountMap.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
