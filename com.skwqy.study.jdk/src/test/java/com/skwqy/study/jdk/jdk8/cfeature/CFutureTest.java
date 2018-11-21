package com.skwqy.study.jdk.jdk8.cfeature;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/20 10:28 PM
 */
public class CFutureTest {
    private static Logger LOG = LoggerFactory.getLogger(CFutureTest.class);

    /**
     * ----------------------- 创建----------------------
     */

    @Test
    public void testCreateCFeature() throws ExecutionException, InterruptedException {
        CompletableFuture<String> strTmp = CompletableFuture.completedFuture("createCompletableFuture");
        Assert.assertEquals("createCompletableFuture", strTmp.get());

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            LOG.info("thread name = {}", Thread.currentThread().getName());
        });
        LOG.info("Future is done = " + cf.isDone());

        CompletableFuture<String> strFuture = CompletableFuture.supplyAsync(() -> {
            return "MyName";
        });
        Assert.assertEquals("MyName", strFuture.get());

    }

    /**
     * ----------------------- 完成----------------------
     * whenComplete/handle
     * 完成:能够处理异常，其它没什么特殊的地方
     * whenComplete：不会改变最终的执行结果
     * handle：会改变执行结果
     */
    @Test
    public void testComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> strTest = CompletableFuture.completedFuture("messageTest").whenComplete((v, th) -> {
            v = v + "Test2";
        }).thenApply(v -> {
            return v + "test";
        });
        Assert.assertEquals("messageTesttest", strTest.get());
        CompletableFuture<String> strChange = CompletableFuture.completedFuture("messageTest").handle((v, th) -> {
            v = v + "Test2";
            return v;
        }).thenApply(v -> {
            return v + "testt";
        });
        Assert.assertEquals("messageTestTest2testt", strChange.get());

    }

    /**
     * ----------------------- 转换----------------------
     * thenApply
     * 实现多个操作串联
     */
    @Test
    public void testLink() throws ExecutionException, InterruptedException {
        CompletableFuture<String> str = CompletableFuture.completedFuture("StringLink");
        CompletableFuture<String> strLink = str.thenApply(v -> {
            return v.toUpperCase(Locale.ENGLISH);
        }).thenApply(v -> {
            return v.toLowerCase(Locale.ENGLISH);
        });
        Assert.assertEquals("stringlink", strLink.get());
    }

    /**
     * ----------------------- 组合 flatMap----------------------
     * thenCompose/thenCombine
     * 实现多个操作串联
     */
    @Test
    public void testCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String[]> strArray = CompletableFuture.completedFuture(new String[]{"str1", "str2", "str3", "str4"});
        CompletableFuture<String> strCf = strArray.thenCompose((v) -> {
            StringBuilder sb = new StringBuilder(100);
            for(String str:v)
            {
                sb.append(str).append(",");
            }
            return CompletableFuture.completedFuture(sb.toString());
        });
        Assert.assertEquals("str1,str2,str3,str4,",strCf.get());
        LOG.info(strCf.get());
    }

}