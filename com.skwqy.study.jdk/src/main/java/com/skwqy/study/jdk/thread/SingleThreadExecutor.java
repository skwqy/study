package com.skwqy.study.jdk.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SingleThreadExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(SingleThreadExecutor.class);
    private final ExecutorService eService = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("skwqy-threadtest-%d").build());

    public void addTask(Runnable task){
        eService.execute(task);
    }

    public static void main(String[] args) {
        SingleThreadExecutor test = new SingleThreadExecutor();

        test.addTask(new Task());

        try {
            TimeUnit.MINUTES.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static class Task implements Runnable {
        @Override
        public void run() {
            int temp = 0;
            int i = 0;
            Random random = new Random();
            while (true) {
                int j = random.nextInt(100);

                System.err.println("temp----------->" + temp + "  i---------------->" + (i++) + "    j------------------>" + j);

                try {

                    if (temp == 0 && j > 90) {
                        temp = 7 / 0;
                    }
                    Thread.currentThread().sleep(10);

                } catch (Exception e) {
                    e.printStackTrace();
                    LOG.error("error", e);
                    temp = 1;
                }
            }
        }
    }
}
