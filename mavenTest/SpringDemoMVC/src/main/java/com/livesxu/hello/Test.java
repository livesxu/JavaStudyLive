package com.livesxu.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.sql.DataSource;

@RestController
public class Test {

    private JedisPool jedisPool;

    //4.0开始推荐使用set方法和构造器方法注入，@Autowired可以省略
    @Autowired
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "hello world";
    }
}
