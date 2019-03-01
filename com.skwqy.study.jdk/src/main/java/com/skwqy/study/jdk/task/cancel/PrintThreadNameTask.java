package com.skwqy.study.jdk.task.cancel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author skwqy
 * @Created on 2019 03 2019-03-01 22:37
 */
public class PrintThreadNameTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(CancelTask1.class);

    @Override
    public void run() {
        LOG.info("threadName = {}",Thread.currentThread().getName());
    }
}
