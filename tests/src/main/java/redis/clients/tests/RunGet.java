package redis.clients.tests;

/**
 * Created by meng li on 2017/4/11.
 */
public class RunGet implements Runnable {
    int from;
    int to;
    public  RunGet(int from1,int to1) {
        this.from=from1;
        this.to=to1;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i=from;i<to;i++) {
            String key1 = "testkeys:runset:from" + from + "to" + to + ":value" + i;
            JedisUtil.getJedisCluster().get(key1);
        }
    }
}
