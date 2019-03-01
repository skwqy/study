package com.skwqy.study.jdk.task.cancel;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 任务无法被取消
 * 
 * @author skwqy
 * @Created on 2019 03 2019-03-01 22:26
 */
public class CancelTask3 implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(CancelTask3.class);

    @Override
    public void run() {
        LOG.info("threadName = {}",Thread.currentThread().getName());

        int index = 0;
        for (; ; ) {
            LOG.info("index = {}", index++);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                LOG.error("task is Interrupted",e);
                return;
            }
        }
    }
}
