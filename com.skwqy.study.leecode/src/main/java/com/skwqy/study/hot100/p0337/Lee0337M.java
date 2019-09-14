package com.skwqy.study.hot100.p0337;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-12 22:24
 */
public class Lee0337M {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];
        if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        }
        int[] leftResult = dfs(node.left);
        int[] rightResult = dfs(node.right);

        int[] res = new int[2];
        res[0] = leftResult[1] + rightResult[1] + node.val;
        res[1] = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
        return res;
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
