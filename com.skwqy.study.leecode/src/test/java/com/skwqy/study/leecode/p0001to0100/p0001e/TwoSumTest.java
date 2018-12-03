package com.skwqy.study.leecode.p0001to0100.p0001e;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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