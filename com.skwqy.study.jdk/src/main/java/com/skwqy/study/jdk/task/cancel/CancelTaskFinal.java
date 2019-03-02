package com.skwqy.study.jdk.task.cancel;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 要做到任务可以取消，必须做到以下三点：
 * 1、interrupted信号必须争取处理，要return
 * 2、InterruptedException 异常要正确处理，处理异常后要直接return
 * 3、避免使用无法被打断的同步方法，比如不要使用Socket同步方法，该方法无法被打断并发挥异常
 * 
 * @author skwqy
 * @Created on 2019 03 2019-03-01 22:26
 */
public class CancelTaskFinal implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(CancelTaskFinal.class);

    @Override
    public void run() {
        LOG.info("threadName = {}",Thread.currentThread().getName());

        int index = 0;
        for (; ; ) {
            LOG.info("index = {}", index++);

            try {
                TimeUnit.HOURS.sleep(2);
            } catch (InterruptedException e) {
                LOG.error("task is Interrupted",e);
                return;
            }

            if(Thread.currentThread().isInterrupted()){
                LOG.info("task is cancelled");
                return;
            }
        }
    }
}
