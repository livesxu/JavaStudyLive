package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

    private RedisUtils(){}

    private static JedisPool jedisPool = null;

    static {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        jedisPool = new JedisPool(config,"localhost",6379);
    }

    static public Jedis getRedis () {

        return jedisPool.getResource();
    }
}
