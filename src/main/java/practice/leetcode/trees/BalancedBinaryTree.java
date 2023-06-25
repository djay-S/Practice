package practice.leetcode.trees;

import com.sun.security.auth.NTUserPrincipal;

import java.util.Arrays;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
    public static void main(String[] args) {
        test(new Integer[]{3,9,20,null,null,15,7}, true);
        test(new Integer[]{1,2,2,3,3,null,null,4,4}, false);
        test(new Integer[]{}, true);
        test(new Integer[]{1,null,2,null,null,null,3}, false);
        test(new Integer[]{1,2,2,3,null,null,3,4,null,null,null,null,null,null,4}, false);
    }

    private static void test(Integer[] rootArr, boolean expected) {
        TreeNode root = TreeNodeUtils.arrToTreeNode(rootArr, 0);
        boolean result = isBalanced(root);
        String finalAnswer = expected == result ? "✅" : "❌";
        System.out.printf("Root: %s, Expected: %s, Result: %s, Final: %s\n", Arrays.asList(rootArr), expected, result, finalAnswer);
    }

    private static boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[]{true};
        kidCountDiff(root, isBalanced);
        return isBalanced[0];
    }

    private static int kidCountDiff(TreeNode root, boolean[] isBalanced) {
        if (root == null) {
            return 0;
        }

        int leftKidCount = kidCountDiff(root.left, isBalanced);
        int rightKidCount = kidCountDiff(root.right, isBalanced);
        isBalanced[0] = Math.abs(leftKidCount - rightKidCount) <= 1 && isBalanced[0];
        return Math.max(leftKidCount, rightKidCount) + 1;
    }
}
