package practice.leetcode.trees;

import java.util.Arrays;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public static void main(String[] args) {
        test(new Integer[]{4,2,7,1,3,6,9}, new Integer[]{4,7,2,9,6,3,1});
        test(new Integer[]{2,1,3}, new Integer[]{2,3,1});
        test(new Integer[]{}, new Integer[]{});
    }

    private static void test(Integer[] rootArr, Integer[] expected) {
        TreeNode root = TreeNodeUtils.arrToTreeNode(rootArr, 0);
        TreeNode invertedTree = invertTree(root);
        Integer[] invertedTreeArr = new Integer[rootArr.length];
        TreeNodeUtils.treeNodeToList(invertedTree, invertedTreeArr, 0);
        String finalAnswer = Arrays.asList(expected).equals(Arrays.asList(invertedTreeArr)) ? "✅" : "❌";
        System.out.printf("Root: %s, Expected: %s, Result: %s, Final: %s\n", Arrays.asList(rootArr), Arrays.asList(expected), Arrays.asList(invertedTreeArr), finalAnswer);
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
