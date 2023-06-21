package practice.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {

    public static void main(String[] args) {
        test(new Integer[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13, false);
        test(new Integer[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3, true);
        test(new Integer[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 5, true);
        test(new Integer[][]{{1}}, 1, true);
        test(new Integer[][]{{1, 3, 5}}, 5, true);
    }

    private static void test(Integer[][] matrix, int target, boolean expected) {
        boolean myAnswer = searchMatrix(matrix, target);
        String finalAnswer = myAnswer == expected ? "✅" : "❌";
        System.out.printf("Matrix: %s, Target: %d, Result: %s, Expected: %s, Final: %s.\n", printArray(matrix), target, myAnswer, expected, finalAnswer);
    }

    private static String printArray(Integer[][] arr) {
        List<List<Integer>> list = new ArrayList();
        for (Integer[] integers : arr) {
            List<Integer> row = new ArrayList<>(Arrays.asList(integers));
            list.add(row);
        }
        return list.toString();
    }

    private static boolean searchMatrix(Integer[][] matrix, int target) {
        int rowLength = matrix[0].length;
        int i = 0;
        while (i < matrix.length) {
            if (matrix[i][0] <= target && matrix[i][rowLength - 1] >= target) {
                Integer[] arr = matrix[i];
                return binarySearch(arr, target);
            }
            i++;
        }
        return false;
    }

    private static boolean binarySearch(Integer[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;

        while (left < right && left <= mid) {
            if (target == arr[mid])
                return true;
            if (target > arr[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid;
                mid = (left + right) / 2;
            }
        }
        return false;
    }
}
