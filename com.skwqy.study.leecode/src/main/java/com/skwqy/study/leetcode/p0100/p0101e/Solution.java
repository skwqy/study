package com.skwqy.study.leetcode.p0100.p0101e;

import com.skwqy.study.leetcode.common.TreeNode;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-04 13:46
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return ismirror(root.left, root.right);
    }

    private boolean ismirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null)
            return false;

        if (left.val != right.val) {
            return false;
        }
        return ismirror(left.left, right.right) && ismirror(left.right, right.left);
    }
}
