package com.skwqy.study.algorithm.sort.impl;

import org.springframework.stereotype.Component;

/**
 * 冒泡排序
 * 时间复杂度：O(N^2)
 *
 * @param <T>
 */
@Component
public class Bubble<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        boolean hasSorted = false;

        // 从数组最后一个元素开始，最为被比较的对象
        for (int index = length - 1; index > 0 && !hasSorted; index--) {
            hasSorted = true;

            // 从数组第一个元素开始,index 以后都是已经拍完序的
            for (int j = 0; j < index; j++) {

                // 如果后面元素比前面元素小，则交换顺序
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}