package com.skwqy.study.jdk.xproxy.aop.xconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/25 2:04 PM
 */
public class AopMain {
    public static void main(String[] args)
    {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("/spring/aop_example.xml");

        HelloWorld hw1 = (HelloWorld)ctx.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld)ctx.getBean("helloWorldImpl2");
        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();

        System.out.println();
        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }
}
