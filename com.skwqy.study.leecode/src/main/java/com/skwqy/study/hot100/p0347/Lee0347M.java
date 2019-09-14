package com.skwqy.study.hot100.p0347;

import java.util.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-12 22:56
 */
public class Lee0347M {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int key : nums) {
            if (count.containsKey(key)) {
                count.put(key, count.get(key) + 1);
            } else {
                count.put(key, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        for (Integer key : count.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (count.get(key) > count.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> result = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            result.add(pq.remove());
        }
        return result;
    }
}
