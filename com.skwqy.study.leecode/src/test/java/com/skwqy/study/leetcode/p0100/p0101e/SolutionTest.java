package com.skwqy.study.leetcode.p0100.p0101e;

import com.skwqy.study.leetcode.common.TreeNode;
import com.skwqy.study.leetcode.common.TreeUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-04 14:01
 */
public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void testIsSymmetric() {
        int[] nodes = {1,2,2,3,4,4,3};
        TreeNode root = TreeUtils.createBTreeByArray(nodes,0);
        Assert.assertEquals(true,solution.isSymmetric(root));
    }

    @Test
    public void testIsSymmetric2() {
        Integer[] nodes = {1,2,2,null,4,null,3};
        TreeNode root = TreeUtils.createBTreeByArray(nodes,0);
        Assert.assertEquals(false,solution.isSymmetric(root));
    }
}