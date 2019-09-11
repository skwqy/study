package com.skwqy.study.hot100.p0234;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 15:23
 */
public class Lee0234E {
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        List<Integer> numbers = new ArrayList<>();
        while (tmp != null) {
            numbers.add(tmp.val);
            tmp = tmp.next;
        }
        return isPalindrome(numbers);
    }

    boolean isPalindrome(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return true;
        }
        int len = numbers.size();
        if (len % 2 == 0) {
            return isEqual(numbers, (len / 2) - 1, len / 2);
        }
        return isEqual(numbers, (len / 2) - 1, (len / 2) + 1);
    }

    boolean isEqual(List<Integer> numbers, int left, int right) {
        int len = numbers.size();
        while (left >= 0 && right < len) {
            if (numbers.get(left).equals(numbers.get(right))) {
                left--;
                right++;
            } else {
                return false;
            }
        }
        return true;
    }
}
