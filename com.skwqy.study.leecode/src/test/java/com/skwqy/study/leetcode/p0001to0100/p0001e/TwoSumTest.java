package com.skwqy.study.leetcode.p0001to0100.p0001e;

import com.skwqy.study.leetcode.p0001to0100.p0001e.TwoSum;
import com.skwqy.study.leetcode.p0001to0100.p0001e.TwoSum2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/3 11:40 PM
 */
public class TwoSumTest {

    @Test
    public void testTwoSum(){
        int[] numbs = new int[]{2,7,11,15};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(numbs,9);
        Assert.assertEquals(0,result[0]);
        Assert.assertEquals(1,result[1]);
    }

    @Test
    public void testTwoSum2(){
        int[] numbs = new int[]{2,7,11,15};
        TwoSum2 twoSum2 = new TwoSum2();
        int[] result = twoSum2.twoSum(numbs,9);
        Assert.assertEquals(0,result[0]);
        Assert.assertEquals(1,result[1]);
    }

}