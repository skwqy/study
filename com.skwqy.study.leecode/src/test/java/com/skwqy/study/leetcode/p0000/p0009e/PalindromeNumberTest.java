package com.skwqy.study.leetcode.p0000.p0009e;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/16 11:30 AM
 */
public class PalindromeNumberTest {

    @Test
    public void isPalindrome() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        Assert.assertTrue(palindromeNumber.isPalindrome(121));
        Assert.assertFalse(palindromeNumber.isPalindrome(1213));
        Assert.assertFalse(palindromeNumber.isPalindrome(10));
        Assert.assertFalse(palindromeNumber.isPalindrome(-10));
    }
}