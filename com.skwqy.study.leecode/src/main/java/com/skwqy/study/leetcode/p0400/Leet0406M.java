package com.skwqy.study.leetcode.p0400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-28 22:02
 */
public class Leet0406M {

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     * <p>
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     * @param people
     * @return
     */

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> res = new ArrayList<>(people.length);

        for (int[] i : people) {
            res.add(i[1], i);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
