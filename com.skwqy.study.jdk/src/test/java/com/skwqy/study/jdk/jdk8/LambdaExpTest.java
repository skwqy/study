package com.skwqy.study.jdk.jdk8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LambdaExpTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Lambda出现在函数式接口应该出现的地方，Runnable、Callable等
     */
    @Test
    public void testSamInterfade(){
        // Java 8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before java8, too much code for runnable.");
            }
        }).start();

        // Java 8 Lambda
        new Thread(() -> System.out.println("Java 8, Lambda exp is here")).start();
    }

    /**
     * 使用Lambda表达式的地方也可以使用函数
     */
    @Test
    public void testListOpt() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        // Before Java 8
        for (String feature : features){
            System.out.println(feature);
        }

        // Java 8
        System.out.println("---------Java 8--------");
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);


    }


}