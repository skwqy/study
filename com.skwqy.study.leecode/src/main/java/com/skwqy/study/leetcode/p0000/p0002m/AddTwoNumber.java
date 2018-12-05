package com.skwqy.study.leetcode.p0000.p0002m;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/5 8:50 PM
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int over = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + over;
            over = sum / 10;
            ListNode tmpNode = new ListNode(sum % 10);
            curr.next = tmpNode;

            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (over > 0){
            curr.next = new ListNode(over);
        }
        return head.next;
    }
}
