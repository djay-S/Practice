package practice.leetcode.trees;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        test(new Integer[]{3,9,20,null,null,15,7}, 3);
        test(new Integer[]{3,9,20,null,5,15,7,71,70,1}, 4);
        test(new Integer[]{1,null,2}, 2);
        test(new Integer[]{}, 0);
    }

    private static void test(Integer[] rootArr, int expected){
        TreeNode root = TreeNodeUtils.arrToTreeNode(rootArr,0);
        int result = maxDepth(root);
        String finalAnswer = result == expected ? "✅" : "❌";
        System.out.printf("Root: %s, Expected: %s, Result: %s, Final: %s\n", Arrays.asList(rootArr), expected, result, finalAnswer);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
