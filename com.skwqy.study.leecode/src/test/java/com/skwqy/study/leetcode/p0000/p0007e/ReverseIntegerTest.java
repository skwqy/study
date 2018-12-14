package com.skwqy.study.leetcode.p0000.p0007e;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/12 11:51 PM
 */
public class ReverseIntegerTest {

    @Test
    public void reverse() {
        ReverseInteger reverseInteger = new ReverseInteger();
        Assert.assertEquals(321,reverseInteger.reverse(123));
        Assert.assertEquals(-321,reverseInteger.reverse(-123));
        Assert.assertEquals(21,reverseInteger.reverse(120));
        System.out.println(Integer.MAX_VALUE);

    }
}