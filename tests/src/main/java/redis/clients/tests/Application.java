package redis.clients.tests;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by meng li on 2017/4/10.
 */
public class Application {


    public static void main(String[] args) {

        //set
        Thread[] threadsSet = new Thread[1];
        for (int i = 0; i < threadsSet.length; i++) {
            threadsSet[i] = new Thread(new RunSet(100 * i, 5 * (i + 1)));
            threadsSet[i].start();
        }

        //get
        Thread[] threadsGet = new Thread[1];
        for (int j = 0; j < threadsGet.length; j++) {
            threadsGet[j] = new Thread(new RunGet(100 * j, 5 * (j + 1)));
            threadsGet[j].start();
        }


    }

}
