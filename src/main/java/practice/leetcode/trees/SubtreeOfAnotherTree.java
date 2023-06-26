package practice.leetcode.trees;

import java.util.Arrays;

//https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        test(new Integer[]{3,4,5,1,2}, new Integer[]{4,1,2}, true);
        test(new Integer[]{3,4,5,1,2,null,null,null,null,0}, new Integer[]{4,1,2}, false);//
        test(new Integer[]{1,1}, new Integer[]{1}, true);
    }

    private static void test(Integer[] rootArr, Integer[] subRootArr, boolean expected) {
        TreeNode root = TreeNodeUtils.arrToTreeNode(rootArr, 0);
        TreeNode subRoot = TreeNodeUtils.arrToTreeNode(subRootArr, 0);
        boolean result = isSubTree(root, subRoot);
        String finalAnswer = expected == result ? "✅" : "❌";
        System.out.printf("Root: %s, Subroot: %s, Expected: %s, Result: %s, Final: %s\n", Arrays.asList(rootArr), Arrays.asList(subRootArr), expected, result, finalAnswer);
    }

    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        boolean isLeftKidTreeSubTree = isSubTree(root.left, subRoot);
        boolean isRightKidTreeSubTree = isSubTree(root.right, subRoot);
        return isLeftKidTreeSubTree || isRightKidTreeSubTree;
    }

    private static boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null && root.val.equals(subRoot.val)) {
            boolean isLeftKidTreeSame = isSubTree(root.left, subRoot.left);
            boolean isRightKidTreeSame = isSubTree(root.right, subRoot.right);
            return isLeftKidTreeSame && isRightKidTreeSame;
        }
        return false;
    }
}
