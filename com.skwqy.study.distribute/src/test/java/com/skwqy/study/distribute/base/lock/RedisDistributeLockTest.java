package com.skwqy.study.distribute.base.lock;

import com.skwqy.study.distribute.redis.sample.RedisFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 01 2019-01-19 17:01
 */
public class RedisDistributeLockTest {
    private static final Logger LOG = LoggerFactory.getLogger(RedisDistributeLockTest.class);
    private IRedisFactory redisFactory = RedisFactory.getInstance();


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLockAndUnLock() throws RedisException {
        RedisDistributeLock distributeLock = new RedisDistributeLock("serviceName", "lockKey", redisFactory);
        try {
            distributeLock.lock();

            boolean locked = distributeLock.tryLock();
            LOG.info("locked, locked = {}", locked);
            Assert.assertFalse(locked);

            distributeLock.unLock(3);
            locked = distributeLock.tryLock();
            LOG.info("unlocked, locked = {}", locked);
            Assert.assertTrue(locked);
        } finally {
            distributeLock.unLock(3);
        }
    }

    /**
     * 测试，分布式锁是否再不显示释放的情况下会失效，锁失效存在以下两种情况：
     * 1、显示释放锁
     * 2、加锁的进程死掉
     * @throws RedisException
     */
    @Test
    public void testLongTimeLock() throws RedisException {
        RedisDistributeLock distributeLock = new RedisDistributeLock("serviceName", "lockKey", redisFactory);
        try {
            distributeLock.lock();

            sleep(20);

            boolean locked = distributeLock.tryLock();
            LOG.info("locked, locked = {}", locked);
            Assert.assertFalse(locked);

            distributeLock.unLock(3);
            locked = distributeLock.tryLock();
            LOG.info("unlocked, locked = {}", locked);
            Assert.assertTrue(locked);
        } finally {
            distributeLock.unLock(3);
        }
    }

    private void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            LOG.error("sleep interrupted",e);
        }
    }
}