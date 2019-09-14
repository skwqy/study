package com.skwqy.study.hot100.p0543;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 10:36
 */
public class Lee0543E {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        max = Math.max(max, lDepth + rDepth);
        return (lDepth > rDepth ? lDepth : rDepth) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
