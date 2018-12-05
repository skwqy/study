package com.skwqy.study.algorithm.sort.impl.select;

import com.skwqy.study.algorithm.sort.impl.AbstractSort;
import org.springframework.stereotype.Component;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/5 9:19 PM
 */
@Component
public class Select<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] nums) {
        int minIdex = 0;
        for (int i = 0, length = nums.length; i < length - 1; i++) {
            minIdex = i;
            for (int j = i + 1; j < length; j++) {
                if(!less(nums[minIdex],nums[j])){
                    minIdex = j;
                }
            }
            if (minIdex != i){
                swap(nums,i,minIdex);
            }
        }
    }
}