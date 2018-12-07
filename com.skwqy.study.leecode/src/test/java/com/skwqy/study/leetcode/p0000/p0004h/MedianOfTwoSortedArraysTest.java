package com.skwqy.study.leetcode.p0000.p0004h;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/7 8:35 PM
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void findMedianSortedArrays() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double result = medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2,3},new int[]{2,3,4});
        Assert.assertEquals(2.5d,result,0.001d);
    }

    @Test
    public void findMedianSortedArrays2() {
        MedianOfTwoSortedArrays2 medianOfTwoSortedArrays2 = new MedianOfTwoSortedArrays2();
        double result = medianOfTwoSortedArrays2.findMedianSortedArrays(new int[]{1,2,3},new int[]{2,3,4});
        Assert.assertEquals(2.5d,result,0.001d);

        double result2 = medianOfTwoSortedArrays2.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        Assert.assertEquals(2.5d,result2,0.001d);
    }
}