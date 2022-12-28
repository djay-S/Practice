package practice.leetcode.twoPointers;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public static void main(String[] args) {
        test("A man, a plan, a canal: Panama", true);
        test("race a car", false);
        test(" ", true);
    }

    private static void test(String string, boolean expected) {
        System.out.printf("Result: %s, Expected: %s\n", isPalindrome(string), expected);
    }

    public static boolean isPalindrome(String string) {

        if (string.length() == 1) {
            return true;
        }
        string = string.toLowerCase().replaceAll("[^A-Za-z0-9]", "");

        if (string.length() == 0) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}