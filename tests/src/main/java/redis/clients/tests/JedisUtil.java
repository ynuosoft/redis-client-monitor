package redis.clients.tests;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Created by meng li on 2017/4/11.
 */
public class JedisUtil {

    private static JedisCluster jedisCluster;
    static  {
        jedisCluster = new JedisCluster(new HostAndPort("113.52.176.29", 53460));
    }

    public  static JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    @Override
    protected void finalize() throws Throwable {
        jedisCluster.close();
        super.finalize();

    }
}
