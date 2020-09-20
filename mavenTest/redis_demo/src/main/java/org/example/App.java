package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

//    https://www.redis.net.cn
//    https://mvnrepository.com/artifact/redis.clients/jedis
//    https://www.redis.net.cn/tutorial/3507.html
    @Test
    public void test1 () {

        RedisUtils.getRedis().set("oneKey","some thing");

        String oneValue = RedisUtils.getRedis().get("oneKey");
        //some thing
        System.out.println(oneValue);

        RedisUtils.getRedis().del("oneKey");

        RedisUtils.getRedis().hset("oneHashKey","name","zhangsan");

        String hNameValue = RedisUtils.getRedis().hget("oneHashKey","name");
        //zhangsan
        System.out.println(hNameValue);

        RedisUtils.getRedis().hdel("oneHashKey","name");

        //list,左侧添加,结果打印应该是cba,因为是依次添加
        RedisUtils.getRedis().lpush("oneListKey","a","b","c");
        //list,右侧添加
        RedisUtils.getRedis().rpush("oneListKey","a","b","c");

        //0到-1 查询所有
        List<String> oneListValues = RedisUtils.getRedis().lrange("oneListKey",0,-1);
        //[c, b, a, a, b, c]
        System.out.println(oneListValues);

        String rOne = RedisUtils.getRedis().rpop("oneListKey");
        //c
        System.out.println(rOne);

        RedisUtils.getRedis().sadd("oneSetKey","a","b","c");

        RedisUtils.getRedis().srem("oneSetKey","a");

        Set<String> oneSetValues = RedisUtils.getRedis().smembers("oneSetKey");
        //[c, b]
        System.out.println(oneSetValues);

        //有序set 一般用在排行榜

        RedisUtils.getRedis().zadd("oneSortedSetKey",100,"a");
        RedisUtils.getRedis().zadd("oneSortedSetKey",80,"b");
        RedisUtils.getRedis().zadd("oneSortedSetKey",90,"c");

        Set<String> oneSortedSetValues = RedisUtils.getRedis().zrange("oneSortedSetKey",0,-1);
        //[b, c, a] 按照score的数值从低到高排列的结果
        System.out.println(oneSortedSetValues);

        Double bScore = RedisUtils.getRedis().zscore("oneSortedSetKey","b");
        //80.0
        System.out.println(bScore);

        //插入一个key,过期时间10秒，一般用在 验证码
        RedisUtils.getRedis().setex("oneOverTimeKey",10,"oneOverTimeValue");

        //查询所有的键 指令 keys *
        RedisUtils.getRedis().keys("*");

        //获取指定key的类型 指令 type key
        RedisUtils.getRedis().type("oneHashKey");

        //删除指定key 指令 del key
        RedisUtils.getRedis().del("oneHashKey");
    }
}
