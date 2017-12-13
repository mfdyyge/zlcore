package com.zl.core.redis.sub;

import com.zl.core.redis.RedisMsgPubSubListener;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 订阅测试类
 *
 * 该类实现对频道redisChatTest的订阅监听，频道的订阅，取消订阅，收到消息都会调用listener对象的对应方法
 * 注意：subscribe是一个阻塞的方法，在取消订阅该频道前，会一直阻塞在这，只有当取消了订阅才会执行下面的other code，参考上面代码，
 * 我在onMessage里面收到消息后，调用了this.unsubscribe(); 来取消订阅，这样才会执行后面的other code
 */
public class SubTest {
    @Test
    public void testSubscribe() throws Exception
    {
        Jedis jedis = new Jedis("localhost");
        RedisMsgPubSubListener msgPubSubListener = new RedisMsgPubSubListener();
        jedis.subscribe(msgPubSubListener, "redisChatTest");//实现对频道redisChatTest的订阅监听
        //other code
    }
}

