package com.skwqy.study.distribute.redis.sample;

import com.skwqy.study.distribute.base.lock.IRedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Nullable;

/**
 * @author skwqy
 * @Created on 2019 01 2019/1/19 1:49 PM
 */
public final class RedisFactory implements IRedisFactory {
    private static final Logger LOG = LoggerFactory.getLogger(RedisFactory.class);
    private static final RedisFactory INSTANCE = new RedisFactory();

    private static JedisPool jedisPool;

    private RedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最多有多少个Jedis实例
        poolConfig.setMaxTotal(10);

        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(2);

        //获得一个jedis实例的时候是否检查连接可用性（ping()）
        poolConfig.setTestOnBorrow(true);

        //return 一个jedis实例给pool时，是否检查连接可用性（ping()）
        poolConfig.setTestOnReturn(true);

        // idle状态监测用异步线程evict进行检查
        poolConfig.setTestWhileIdle(true);

        // 一次最多evict的pool里的jedis实例个数
        poolConfig.setNumTestsPerEvictionRun(10);

        // test idle 线程的时间间隔
        poolConfig.setTimeBetweenEvictionRunsMillis(60000);

        // 最大等待wait时间
        poolConfig.setMaxWaitMillis(3000);

        jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);
    }

    public static RedisFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Jedis getRedis() {
        return jedisPool.getResource();
    }

    @Override
    public void closeRedis(@Nullable Jedis jedis) {
            jedisPool.returnResource(jedis);
    }
}
