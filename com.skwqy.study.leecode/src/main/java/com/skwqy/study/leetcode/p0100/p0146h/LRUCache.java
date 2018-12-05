package com.skwqy.study.leetcode.p0100.p0146h;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer,Integer> map;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key,value);
    }
}