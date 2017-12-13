package com.zl.core.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedis2 {

    JedisPool pool;
    Jedis jedis;

    @Before
    public void start() {

        // 初始化Redis连接池
        pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
        // 从Redis连接池中获取一个连接
        jedis = pool.getResource();
        // Redis的密码，对应redis.windows.conf中的masterauth
        //jedis.auth("12345");

    }

    /**
     * 添加测试
     */
    @Test
    public void putTest() {

        jedis.set("user", "YoriChan");
        System.out.println(jedis.get("user"));

        // 输出结果：YoriChan

    }

    /**
     * 覆盖测试
     */
    @Test
    public void overWriteTest() {

        jedis.set("user", "chanyulin");
        System.out.println(jedis.get("user"));

        // 输出结果：chanyulin

    }

    /**
     * 追加测试
     */
    @Test
    public void appendTest() {

        jedis.append("user", "陈昱霖");
        System.out.println(jedis.get("user"));

        // 输出结果：chanyulin陈昱霖

    }

    /**
     * 删除测试
     */
    @Test
    public void deleteTest() {

        jedis.del("user");
        System.out.println(jedis.get("user"));

        // 输出结果：null

    }

}