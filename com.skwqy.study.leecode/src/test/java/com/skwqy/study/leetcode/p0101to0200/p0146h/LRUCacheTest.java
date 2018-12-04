package com.skwqy.study.leetcode.p0101to0200.p0146h;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/4 9:54 PM
 */
public class LRUCacheTest {

    @Test
    public void testLRUCache(){
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1,cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1,cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        Assert.assertEquals(-1,cache.get(1));       // returns -1 (not found)
        Assert.assertEquals(3,cache.get(3));       // returns 3
        Assert.assertEquals(4,cache.get(4));       // returns 4
    }
}