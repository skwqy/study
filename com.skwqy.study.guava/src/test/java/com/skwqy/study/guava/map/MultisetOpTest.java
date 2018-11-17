package com.skwqy.study.guava.map;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 10:35 AM
 */
public class MultisetOpTest {

    /**
     * Multiset不是一个Set，它继承的是Collection<E>接口
     *
     * Multiset可以添加重复的元素，Multiset会对添加的元素做一个计数
     */
    @Test
    public void testWordsCount() {
        Multiset multiset = HashMultiset.create();
        String sentences = "this is a story, there is a good girl in the story.";
        Iterable<String> words = Splitter.onPattern("[^a-z]{1,}").omitEmptyStrings().trimResults().split(sentences);
        for (String word : words) {
            multiset.add(word);
        }
        for (Object element : multiset.elementSet()) {
            System.out.println((String) element + ":" + multiset.count(element));
        }
    }
}