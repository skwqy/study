package com.skwqy.study.hot100.p0207;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 23:01
 */
public class Lee0207M_BFS2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }
        int[] inDegrees = new int[numCourses];
        for (int[] req : prerequisites) {
            inDegrees[req[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int noDepend = que.remove();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != noDepend) {
                    continue;
                }
                if (--inDegrees[req[0]] == 0) {
                    que.add(req[0]);
                }
            }

        }
        return numCourses == 0;
    }
}
