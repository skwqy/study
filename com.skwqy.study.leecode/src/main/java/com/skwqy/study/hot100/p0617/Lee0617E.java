package com.skwqy.study.hot100.p0617;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 15:41
 */
public class Lee0617E {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 == null) {
            return new TreeNode(t1.val);
        } else if (t1 == null && t2 != null) {
            return new TreeNode(t2.val);
        } else if (t1 != null && t2 != null) {
            return new TreeNode(t1.val + t2.val);
        }

        if (t1.left != null || t2.left != null) {
            t1.left = merge(t1.left, t2.left);
        }

        if (t1.right != null || t2.right != null) {
            t1.right = merge(t1.right, t2.right);
        }
        return t1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
