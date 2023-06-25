package practice.leetcode.trees;

import java.util.Arrays;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        test(new Integer[]{1,2,3,4,5}, 3);
        test(new Integer[]{1,2}, 1);
        test(new Integer[]{1,2,3,4,5,null,null,6,null,null,null,7}, 5);
        test(new Integer[]{1,2,null,4,5,null,null,6,null}, 3);
        test(new Integer[]{1,null,4,5,null,null,6,null}, 3);
        test(new Integer[]{1,2,3,4,5,null,null,6,null,null,8,7,null,9}, 6);
    }

    private static void test(Integer[] rootArr, int expected) {
        TreeNode root = TreeNodeUtils.arrToTreeNode(rootArr, 0);
        int result = diameterOfBinaryTree(root);
        String finalAnswer = result == expected ? "✅" : "❌";
        System.out.printf("Root: %s, Expected: %s, Result: %s, Final: %s\n", Arrays.asList(rootArr), expected, result, finalAnswer);
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        int[] distance = new int[1];
        height(root, distance);
        return distance[0];
    }

    private static int height(TreeNode root, int[] distance) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left, distance);
        int right = height(root.right, distance);
        distance[0] = Math.max(distance[0], left + right);
        return 1 + Math.max(left, right);
    }
}
