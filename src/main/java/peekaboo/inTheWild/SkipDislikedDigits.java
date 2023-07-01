package peekaboo.inTheWild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 A number 'N' and an array of disliked digits 'd' are given. Give the minimum number >= N such that it does not
 contain any of the disliked digits.
 N = 100, d = [0,1] res = 222
 N = 6, d = [0,1,2,3,4,6,7,8,9] res = 55
 0 < N, 0 <= [...]d < 10, d is naturally sorted
*/
public class SkipDislikedDigits {
    public static void main(String[] args) {
        test(100, new Integer[]{0,1}, 222);
        test(10, new Integer[]{0,2,4}, 11);
        test(9999, new Integer[]{4,6,7}, 9999);
        test(6, new Integer[]{0,1,2,3,4,6,7,8,9}, 55);
        test(69, new Integer[]{0,1,2,3,4,6,7,8,9}, 555);
        test(69, new Integer[]{0,1,2,3,4,5,6,7,8}, 99);
    }

    private static void test(int N, Integer[] d, int expected) {
        int result = skipDislikedDigitsBruteForce(N, d);
        String finalAnswer = expected == result ? "✅" : "❌";
        System.out.printf("N: %s, d: %s, Expected: %s, Result: %s, Final:%s\n", N, Arrays.asList(d), expected, result, finalAnswer);
    }

    private static int skipDislikedDigitsBruteForce(int N, Integer[] d) {
        int result = N;
        while (true) {
            List<Integer> digits = getDigitsFromNumber(result);
            boolean isNUpdated = false;
            for (int i = 0; i < digits.size(); i++) {
                while (numberHasDislikedDigit(digits.get(i), d)) {
                    result++;
                    digits = getDigitsFromNumber(result);
                    isNUpdated = true;
                }
            }
            if (!isNUpdated) {
                break;
            }
        }
        return result;
    }

    private static int getDigitFromGivenPlace(int N, int place) {
        String numStr = String.valueOf(N);
        String[] strArr = numStr.split("");
        return Integer.parseInt(strArr[place]);
    }

    private static boolean numberHasDislikedDigit(int N, Integer[] d) {
        for (int i = 0; i < d.length; i++) {
            if (d[i] == N) {
                return true;
            }
            if (d[i] > N) {
                return false;
            }
        }
        return false;
    }

    private static List<Integer> getDigitsFromNumber(int N) {
        List<Integer> reversedDigits = new ArrayList<>();

        while (N > 0) {
            int digit = N % 10;
            reversedDigits.add(digit);
            N = N / 10;
        }
        List<Integer> digits = new ArrayList<>();
        for (int i = reversedDigits.size() - 1; i > -1; i--) {
            digits.add(reversedDigits.get(i));
        }
        return digits;
    }
}
