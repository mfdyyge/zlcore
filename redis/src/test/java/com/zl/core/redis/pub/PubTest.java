package com.zl.core.redis.pub;

import org.junit.Test;
import redis.clients.jedis.Jedis;


/**
 * 发布消息测试类
 *  这个类向频道redisChatTest发布消息，第二步因为订阅了该频道，所以会收到该消息
 */
public class PubTest {

    @Test
    public void testPublish() throws Exception
    {
        Jedis jedis = new Jedis("localhost");
/*        jedis.publish("redisChatTest", "我是天才");//这个类向频道redisChatTest发布消息
        Thread.sleep(5000);*/
        jedis.publish("redisChatTest", "我牛逼");//这个类向频道redisChatTest发布消息
        Thread.sleep(5000);
        jedis.publish("redisChatTest", "哈哈");//这个类向频道redisChatTest发布消息
    }
}
