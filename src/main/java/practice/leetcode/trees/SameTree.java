package practice.leetcode.trees;

import java.util.Arrays;

//https://leetcode.com/problems/same-tree/
public class SameTree {
    public static void main(String[] args) {
        test(new Integer[]{1,2,3}, new Integer[]{1,2,3}, true);
        test(new Integer[]{1,2}, new Integer[]{1,null,2}, false);
        test(new Integer[]{1,2,1}, new Integer[]{1,1,2}, false);
    }

    private static void test(Integer[] pArr, Integer[] qArr, boolean expected) {
        TreeNode p = TreeNodeUtils.arrToTreeNode(pArr, 0);
        TreeNode q = TreeNodeUtils.arrToTreeNode(qArr, 0);
        boolean result = isSameTree(p, q);
        String finalAnswer = result == expected ? "✅" : "❌";
        System.out.printf("P: %s, Q:%s, Expected: %s, Result: %s, Final:%s\n", Arrays.asList(pArr), Arrays.asList(qArr), expected, result, finalAnswer);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if ((p.left == null && p.right == null) && (q.left != null && q.right != null)) {
            return false;
        }

        if ((p.left != null && p.right != null) && (q.left == null && q.right == null)) {
            return false;
        }

        if ((p.left == null && p.right == null) && (q.left == null && q.right == null)) {
            return p.val.equals(q.val);
        }

        boolean isLeftKidSame = isSameTree(p.left, q.left);
        boolean isRightKidSame = isSameTree(p.right, q.right);
        return isLeftKidSame && isRightKidSame && (p.val.equals(q.val));
    }
}
