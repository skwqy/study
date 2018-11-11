package com.skwqy.study.jdk.jdk8;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class Jdk8NewFeatureTest {
    public List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /**
     * 1.Lambda表达式
     */
    @Test
    public void testLambda() {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("style：" + e));
    }

}