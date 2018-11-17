package com.skwqy.study.jdk.jdk8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * 参考： http://www.importnew.com/16436.html
 */
public class LambdaExpTest {
    public static Logger LOG = LoggerFactory.getLogger(LambdaExpTest.class);

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
                LOG.info("before java8, too much code for runnable.");
            }
        }).start();

        // Java 8 Lambda
        new Thread(() -> LOG.info("Java 8, Lambda exp is here")).start();
    }

    /**
     * 使用Lambda表达式的地方也可以使用函数
     */
    @Test
    public void testListOpt() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        // Before Java 8
        for (String feature : features){
            LOG.info(feature);
        }

        // Java 8
        System.out.println("---------Java 8--------");
        features.forEach(n -> LOG.info(n));
        features.forEach(System.out::println);
    }

    /**
     * Lambda表达式👌函数式编程
     */
    @Test
    public void testFunctionInterface(){
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startsWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() == 4;
        languages.stream().filter(startsWithJ.and(fourLetterLong)).forEach(n -> System.out.println(n));
    }

    @Test
    public void testMapReduce(){
        // 不使用lambda表达式为每个订单加上12%的税
        List<Double> costBeforeTax = Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0);
        // 为每个订单加上12%的税
        costBeforeTax.stream().map(cost -> cost + 0.12 * cost).forEach(System.out::println);

        // 求和
        double bill = costBeforeTax.stream().map(cost -> cost * 1.12).reduce((sum, cost) -> sum += cost ).get();
        LOG.info("bill sum = {}", bill);
    }

    @Test
    public void testItemJoin(){
        // 将字符串换成大写并用逗号链接起来
        List<String> counties = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = counties.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        LOG.info(G7Countries);
    }

    @Test
    public void testDistinct(){
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        LOG.info("Original List : {},  Square Without duplicates : {}", numbers, distinct);
    }

    @Test
    public void testSummary(){
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        LOG.info("Highest prime number in List : {}", stats.getMax());
        LOG.info("Lowest prime number in List : {}", stats.getMin());
        LOG.info("Sum of all prime numbers : {}", stats.getSum());
        LOG.info("Average of all prime numbers : {}", stats.getAverage());
    }


}