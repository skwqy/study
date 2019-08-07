package com.skwqy.study.leetcode.p0200.p0226e;

import java.util.Arrays;

import com.skwqy.study.leetcode.common.TreeNode;
import com.skwqy.study.leetcode.common.TreeUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-04 15:23
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void invertTree() {
        Integer[] values = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeUtils.createBTreeByArray(values, 0);
        solution.invertTree(root);

        Integer[] expect = {4, 7, 2, 9, 6, 3, 1};
        Integer[] result = TreeUtils.toArrayByBfs(root);

        Assert.assertArrayEquals(expect,result);
//        System.out.println(Arrays.toString(result));
    }

    @Test
    public void invertTree2() {
        Integer[] values = {1,2};
        TreeNode root = TreeUtils.createBTreeByArray(values, 0);
        solution.invertTree(root);

//        Integer[] expect = {1,null,2};
//        Integer[] result = TreeUtils.treeNodeToArray(root);
//
//        Assert.assertArrayEquals(expect,result);
//        System.out.println(Arrays.toString(result));
    }
}