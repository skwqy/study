package com.skwqy.study.hot100.p0234;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 15:34
 */
public class Lee0234ETest {
    Lee0234E ins = new Lee0234E();

    @Test
    public void isPalindrome4() {
        ListNode node = new ListNode(-129);
        ListNode node2 = new ListNode(-129);
        node.next = node2;

        assertTrue(ins.isPalindrome(node));
    }

    @Test
    public void isPalindrome() {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(2);
        assertFalse(ins.isPalindrome(inputs));
    }

    @Test
    public void isPalindrome2() {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(2);
        inputs.add(1);
        assertTrue(ins.isPalindrome(inputs));
    }

    @Test
    public void isPalindrome3() {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(1);
        assertTrue(ins.isPalindrome(inputs));
    }
}