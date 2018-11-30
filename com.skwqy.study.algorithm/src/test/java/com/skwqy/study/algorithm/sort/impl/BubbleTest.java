package com.skwqy.study.algorithm.sort.impl;

import com.skwqy.study.algorithm.sort.ISort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/30 11:16 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:spring/spring.xml"})//加载spring配置文件
public class BubbleTest {
    private static final Logger LOG = LoggerFactory.getLogger(Bubble.class);

    @Qualifier("bubble")
    @Autowired
    private ISort sort;

    @Test
    public void testSort(){
        LOG.info(sort.getClass().getName());
        Integer[] integers = {5,9,8,1,3};
        sort.sort(integers);
        Assert.assertEquals(1,integers[0].intValue());
        Assert.assertEquals(3,integers[1].intValue());
        Assert.assertEquals(5,integers[2].intValue());
        Assert.assertEquals(8,integers[3].intValue());
        Assert.assertEquals(9,integers[4].intValue());
    }
}