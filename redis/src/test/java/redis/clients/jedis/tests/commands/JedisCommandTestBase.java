package redis.clients.jedis.tests.commands;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.ComparisonFailure;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.tests.HostAndPortUtil;

public abstract class JedisCommandTestBase {
  protected static HostAndPort hnp = HostAndPortUtil.getRedisServers().get(0);

  protected Jedis jedis;

  public JedisCommandTestBase() {
    super();
  }

  @Before
  public void setUp() throws Exception 
  {
    System.out.println("hnp.getHost() = " + hnp.getHost());
    System.out.println("hnp.getPort() = " + hnp.getPort());
    jedis = new Jedis(hnp.getHost(), hnp.getPort(), 500);
    jedis.connect();
    /**
     * jedis.auth("foobared"); 服务器没有设置密码这里发送密码请求会报错
     * redis.clients.jedis.exceptions.JedisDataException: ERR Client sent AUTH, but no password is set
     */

    //jedis.auth("foobared");
    jedis.configSet("timeout", "300");
    jedis.flushAll();
  }


  @After
  public void tearDown() {
    jedis.disconnect();
  }

  protected Jedis createJedis() {
    Jedis j = new Jedis(hnp.getHost(), hnp.getPort());
    j.connect();
    j.auth("foobared");
    j.flushAll();
    return j;
  }

  protected boolean arrayContains(List<byte[]> array, byte[] expected) {
    for (byte[] a : array) {
      try {
        assertArrayEquals(a, expected);
        return true;
      } catch (AssertionError e) {

      }
    }
    return false;
  }

  protected boolean setContains(Set<byte[]> set, byte[] expected) {
    for (byte[] a : set) {
      try {
        assertArrayEquals(a, expected);
        return true;
      } catch (AssertionError e) {

      }
    }
    return false;
  }
}
