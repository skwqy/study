package com.skwqy.study.distribute.redis.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.List;

/**
 * @author skwqy
 * @Created on 2019 01 2019/1/19 1:40 PM
 */
public class JedisMain {
    private static final Logger LOG = LoggerFactory.getLogger(JedisMain.class);
    private static final String UNLOCK_LUA = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del'," +
            "KEYS[1]) else return 0 end";


    private static final String RENEW_LOCK_LUA = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call" +
            "('expire',KEYS[1],ARGV[2]) else return 0 end";
    public static final String KEY = "foo1";
    public static final String VALUE = "barrr";

    public static void main(String[] args) {
        Jedis jedis = null;
        jedis = RedisFactory.getInstance().getRedis();
        if(jedis == null){
            LOG.error("get reids error.");
            return;
        }

        try {
            // 加锁
            String result = jedis.set(KEY, VALUE, "NX", "EX", 10);
            LOG.info("lock result = {}",result);

            String lockValue  = jedis.get(KEY);
            LOG.info("lock lockValue = {}",lockValue);

            // 解锁
            List<String> keys = new LinkedList<>();
            keys.add(KEY);

            List<String> argvs = new LinkedList<>();
            argvs.add(VALUE);

            Object unLockResult = jedis.eval(UNLOCK_LUA,keys,argvs);
            if("1".equals(unLockResult.toString())){
                LOG.info("1L");
            }
            LOG.info("unlock result = {}",unLockResult);

            lockValue  = jedis.get(KEY);
            LOG.info("unlock lockValue = {}",lockValue);
        }
        finally {
            RedisFactory.getInstance().closeRedis(jedis);
        }


    }
}
