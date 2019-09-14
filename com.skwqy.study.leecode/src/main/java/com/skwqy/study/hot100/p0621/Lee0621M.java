package com.skwqy.study.hot100.p0621;

import java.util.HashMap;
import java.util.Map;

import org.checkerframework.checker.units.qual.C;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 15:20
 */
public class Lee0621M {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            if (counts.containsKey(task)) {
                counts.put(task, counts.get(task) + 1);
            } else {
                counts.put(task, 1);
            }
        }

        int max = 0;
        for (int count : counts.values()) {
            max = Math.max(max, count);
        }

        int maxCharCount = 0;
        for (int count : counts.values()) {
            if (count == max) {
                maxCharCount++;
            }
        }

        int ans = (max - 1) * (n + 1) + maxCharCount;
        return Math.max(ans, tasks.length);
    }
}
