package com.skwqy.study.leetcode.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-04 16:08
 */
public class TreeUtilsTest {

    @Test
    public void createBTreeByArray() {
        Integer[] values = {1,2};
        TreeNode root = TreeUtils.createBTreeByArray(values,0);
        Assert.assertEquals(null,root.right);
    }

    @Test
    public void toArrayByBfs() {
        Integer[] values = {1,2,3,4,5,6,7};
        TreeNode root = TreeUtils.createBTreeByArray(values,0);

        Integer[] expect = {1,2,3,4,5,6,7};
        Integer[] result = TreeUtils.toArrayByBfs(root);

        Assert.assertArrayEquals(expect,result);
    }

    public void toArrayByDfs(){
        Integer[] values = {1,2,3,4,5,6,77};
        TreeNode root = TreeUtils.createBTreeByArray(values,0);

        Integer[] expect = {1,2,4,5,3,6,7};
        Integer[] result = TreeUtils.toArrayByDfs(root);

        Assert.assertArrayEquals(expect,result);
    }
}