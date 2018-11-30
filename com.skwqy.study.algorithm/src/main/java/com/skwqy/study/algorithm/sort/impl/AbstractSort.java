package com.skwqy.study.algorithm.sort.impl;

import com.skwqy.study.algorithm.sort.ISort;

public abstract class AbstractSort<T extends Comparable<T>> implements ISort<T> {

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}