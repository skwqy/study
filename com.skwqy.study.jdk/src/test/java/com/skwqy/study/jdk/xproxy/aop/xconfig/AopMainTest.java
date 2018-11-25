package com.skwqy.study.jdk.xproxy.aop.xconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/25 2:36 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/aop_example.xml")
public class AopMainTest {

    @Qualifier("helloWorldImpl1")
    @Autowired
    private HelloWorld helloWorld1;

    @Qualifier("helloWorldImpl1")
    @Autowired
    private HelloWorld helloWorld2;

    @Test
    public void testAop()
    {
        helloWorld1.printHelloWorld();
        System.out.println();
        helloWorld1.doPrint();

        System.out.println();
        helloWorld2.printHelloWorld();
        System.out.println();
        helloWorld2.doPrint();
    }
}