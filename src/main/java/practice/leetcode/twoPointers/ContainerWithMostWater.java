package practice.leetcode.twoPointers;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        test(new int[]{1,8,6,2,5,4,8,3,7}, 49);
        test(new int[]{1,1}, 1);
        test(new int[]{2,0,2}, 4);
        test(new int[]{1,0,1}, 2);
    }

    private static void test(int[] height, int expected) {
        System.out.printf("Result: %d, Expected: %d.\n", maxArea(height), expected);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = 0;
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            }
            else {
                area = height[right] * (right - left);
                right--;
            }

            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
