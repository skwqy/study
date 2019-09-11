package com.skwqy.study.hot100.p0207;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 23:01
 */
public class Lee0207M_BFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> depends = new ConcurrentHashMap<>();
        for (int[] prerequisite : prerequisites) {
            depends.computeIfAbsent(prerequisite[0], k ->
                    new HashSet()
            ).add(prerequisite[1]);
        }

        Queue<Integer> noDepends = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!depends.containsKey(i)) {
                noDepends.add(i);
            }
        }

        while (!noDepends.isEmpty()) {
            int noDepend = noDepends.remove();
            for (Map.Entry<Integer, Set<Integer>> entry : depends.entrySet()) {
                Set<Integer> value = entry.getValue();
                value.remove(noDepend);
                if (value.isEmpty()) {
                    noDepends.add(entry.getKey());
                    depends.remove(entry.getKey());
                }
            }

        }
        return depends.isEmpty();
    }
}
