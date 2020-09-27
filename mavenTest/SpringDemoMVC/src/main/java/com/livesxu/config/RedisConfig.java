package com.livesxu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    @Value("${redis.host}")
    String host;

    @Value("${redis.port}")
    int port;

    @Value("${redis.maxTotal}")
    int maxTotal;

    @Value("${redis.maxIdle}")
    int maxIdle;

    @Bean
    public JedisPool jedisPool(){

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);

        JedisPool jedisPool = new JedisPool(config,host,port);

        return jedisPool;
    }
}
