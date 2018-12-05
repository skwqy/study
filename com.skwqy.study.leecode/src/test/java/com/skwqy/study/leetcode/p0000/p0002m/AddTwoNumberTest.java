package com.skwqy.study.leetcode.p0000.p0002m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/5 9:02 PM
 */
public class AddTwoNumberTest {

    @Test
    public void testAddTwoNumber(){
        ListNode p = new ListNode(2);
        p.next = new ListNode(4);
        p.next.next = new ListNode(3);

        ListNode q = new ListNode(5);
        q.next = new ListNode(6);
        q.next.next = new ListNode(4);

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(p,q);
        Assert.assertEquals(7,result.val);
        Assert.assertEquals(0,result.next.val);
        Assert.assertEquals(8,result.next.next.val);
    }
}