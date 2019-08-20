package com.skwqy.study.leetcode.p0000.p0010;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 18:00
 */
public class Leet0023h {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length ==1){
            return lists[0];
        }
        ListNode root = lists[0];
        for (int i = 1, len = lists.length; i < len; i++) {
            root = mergeTwoLists(root, lists[i]);
        }
        return root;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode currentNode = new ListNode(0);
        ListNode root = currentNode;

        ListNode left = l1;
        ListNode right = l2;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                currentNode.next = left;
                left = left.next;

            } else if (left.val > right.val) {
                currentNode.next = right;
                right = right.next;
            }
            currentNode = currentNode.next;
            currentNode.next = null;
        }
        if (left != null) {
            currentNode.next = left;
        }
        if (right != null) {
            currentNode.next = right;
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
