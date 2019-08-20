package com.skwqy.study.leetcode.p0000.p0010;

import com.skwqy.study.leetcode.p0000.p0002m.ListNode;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 17:24
 */
public class Leet0021e {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode currentNode = new ListNode(0);
        ListNode root = currentNode;

        ListNode left = l1;
        ListNode right = l2;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                currentNode.next = left;
                left = left.next;

            } else if (left.val > right.val){
                currentNode.next = right;
                right = right.next;
            }
            currentNode = currentNode.next;
            currentNode.next = null;
        }
        if(left !=null){
            currentNode.next = left;
        }
        if(right!=null){
            currentNode.next=right;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
