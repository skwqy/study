package com.skwqy.study.jdk.task.cancel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 任务无法被取消
 * 
 * @author skwqy
 * @Created on 2019 03 2019-03-01 22:26
 */
public class CancelTask2 implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(CancelTask2.class);

    @Override
    public void run() {
        LOG.info("threadName = {}",Thread.currentThread().getName());

        int index = 0;
        for (; ; ) {
            LOG.info("index = {}", index++);
            if(Thread.interrupted()){
                LOG.info("task is cancelled");
                return;
            }
        }
    }
}
