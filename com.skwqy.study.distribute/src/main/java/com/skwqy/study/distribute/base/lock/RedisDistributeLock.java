package com.skwqy.study.distribute.base.lock;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 分布式锁
 *
 * @author skwqy
 * @Created on 2019 01 2019/1/18 10:00 PM
 */
public class RedisDistributeLock {
    private static final String UNLOCK_LUA = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del'," +
            "KEYS[1]) else return 0 end";


    private static final String RENEW_LOCK_LUA = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call" +
            "('Expire',KEYS[1],ARGV[2]) else return 0 end";
    public static final long EXPIRE_TIME = 10L;

    private ThreadFactory threadFactory =
            new ThreadFactoryBuilder().setNameFormat("RedisDistributeLock-TimeLock-%d").build();
    private ScheduledThreadPoolExecutor scheduledService = new ScheduledThreadPoolExecutor(1, threadFactory);

    private AtomicReference<Future> atomicRef = new AtomicReference<>();
    private String lockValue = UUID.randomUUID().toString();
    private final String lockKey;
    private final IRedisFactory redisFactory;

    public RedisDistributeLock(String serviceName, String key, IRedisFactory redisFactory) {
        lockKey = serviceName + key;
        this.redisFactory = redisFactory;
    }

    /**
     * 加锁，直到加锁成功为止
     * @throws RedisException
     */
    public void lock() throws RedisException {
        while (!tryLock()) {
            sleep(500L);
        }
    }

    /**
     * 加锁，指定时间内加锁不成功就返回
     * @param timeOut 超时时间
     * @return 释放加锁成功 true：成功，false：失败
     * @throws RedisException
     */
    public boolean lock(long timeOut) throws RedisException {
        long startTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        while (!tryLock()) {
            long restTime =
                    startTime + TimeUnit.SECONDS.toMillis(timeOut) - TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            if (restTime <= 0L) {
                return false;
            }
            restTime = restTime > 500L ? 500L : restTime;
            this.sleep(restTime);
        }
        return true;
    }

    /**
     * 尝试加锁，加锁一次,加锁成功以后，出现以下场景会失效：
     * 1、主动解锁
     * 2、加锁的进程挂死
     * @return 加锁是否成功，true：成功，false：失败
     * @throws RedisException
     */
    public boolean tryLock() throws RedisException {
        boolean isGetLock = lockUnblocked(EXPIRE_TIME);
        if (!isGetLock) {
            return false;
        }
        Future future = scheduledService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                RedisDistributeLock.this.renewLock();
            }
        }, 5L, 5L, TimeUnit.SECONDS);
        Future existFuture = atomicRef.getAndSet(future);
        if (existFuture != null) {
            existFuture.cancel(false);
        }
        return true;
    }

    /**
     * 非阻塞加锁,获取不到锁立即返回
     *
     * @param expireTime Redis锁超时时间，超过指定时间，其它节点加锁将会成功
     * @return
     * @throws RedisException
     */
    public boolean lockUnblocked(long expireTime) throws RedisException {
        Jedis redis = redisFactory.getRedis();
        if (redis == null) {
            throw new RedisException();
        }
        try {
            String result = redis.set(lockKey, lockValue, "NX", "EX", expireTime);
            return "OK".equals(result);
        } finally {
            redisFactory.closeRedis(redis);
        }
    }

    /**
     * 释放锁
     * @param retryCount 释放次数
     * @return 释放结果。true：释放成功，false：释放失败
     */
    public boolean unLock(int retryCount) {
        Future exsitingFuture = atomicRef.getAndSet(null);
        if (exsitingFuture != null) {
            exsitingFuture.cancel(false);
        }
        return this.unLockUnblocked(retryCount);
    }

    /**
     *
     * @param retryCount
     * @return
     */
    private boolean unLockUnblocked(int retryCount) {
        Jedis redis = redisFactory.getRedis();
        if (redis == null) {
            return false;
        }
        try {
            while (retryCount-- > 0) {

                Object result = redis.eval(UNLOCK_LUA, Lists.<String>newArrayList(lockKey),
                        Lists.newArrayList(lockValue));
                if (result != null && "1".equals(result.toString())) {
                    return true;
                }
                this.sleep(500L);
            }
        } finally {
            redisFactory.closeRedis(redis);
        }
        return false;
    }

    private boolean renewLock() {
        Jedis redis = redisFactory.getRedis();
        if (redis == null) {
            return false;
        }
        try {
            Object result = redis.eval(RENEW_LOCK_LUA, Lists.<String>newArrayList(lockKey),
                    Lists.newArrayList(lockValue,String.valueOf(EXPIRE_TIME)));
            if (result != null && "1".equals(result.toString())) {
                return true;
            }
        } finally {
            redisFactory.closeRedis(redis);
        }
        return false;
    }

    private void sleep(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
