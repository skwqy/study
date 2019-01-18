package com.skwqy.study.distribute.base.lock;

import redis.clients.jedis.Jedis;

/**
 * Redis 工厂
 *
 * @author skwqy
 * @Created on 2019 01 2019/1/18 10:01 PM
 */
public interface IRedisFactory {
    /**
     * 获取Jedis对象
     *
     * @return Redis对象
     */
    Jedis getRedis();

    /**
     * 关闭Redis
     */
    void closeRedis(Jedis redis);
}
