package com.skwqy.study.distribute.base.lock;

import com.skwqy.study.distribute.redis.sample.RedisFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void unLock() throws RedisException {
        RedisDistributeLock distributeLock = new RedisDistributeLock("serviceName","lockKey",redisFactory);
        try {
            distributeLock.lock();

            boolean locked = distributeLock.tryLock();
            LOG.info("locked, locked = {}",locked);
            Assert.assertFalse(locked);

            distributeLock.unLock(3);
            locked = distributeLock.tryLock();
            LOG.info("unlocked, locked = {}",locked);
            Assert.assertTrue(locked);
        }
        finally {
            distributeLock.unLock(3);
        }
    }

    @Test
    public void unLockUnblocked() {
    }
}