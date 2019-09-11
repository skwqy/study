package com.skwqy.study.hot100.p0046;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-11 23:09
 */
public class Lee0046M {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        int len = nums.length;
        List<Integer> inputs = new LinkedList<>();
        for (int value : nums) {
            inputs.add(value);
        }
        List<List<Integer>> result = new LinkedList<>();
        backTrack(inputs, result, 0);
        return result;
    }

    private void backTrack(List<Integer> inputs, List<List<Integer>> result, int first) {
        if (first == inputs.size()) {
            result.add(new ArrayList<>(inputs));
        }

        for (int i = first, len = inputs.size(); i < len; i++) {
            Collections.swap(inputs, first, i);
            backTrack(inputs, result, first + 1);
            Collections.swap(inputs, first, i);
        }
    }
}
