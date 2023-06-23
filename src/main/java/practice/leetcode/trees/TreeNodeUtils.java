package practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtils {
    public static TreeNode arrToTreeNode(Integer[] arr, int index) {
        if (arr.length == 0 || index >= arr.length) {
            return null;
        }

        TreeNode tree = new TreeNode(arr[index]);
        tree.left = arrToTreeNode(arr, getLeftIndex(index));
        tree.right = arrToTreeNode(arr, getRightIndex(index));
        return tree;
    }

    private static int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightIndex(int index) {
        return 2 * index + 2;
    }

    public static void treeNodeToList(TreeNode tree, Integer[] list, int index) {
        if (tree == null) {
            return;
        }
            list[index] = tree.val;
            treeNodeToList(tree.left, list, getLeftIndex(index));
            treeNodeToList(tree.right, list, getRightIndex(index));
        return;
    }
}
