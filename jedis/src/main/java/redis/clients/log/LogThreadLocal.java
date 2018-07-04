package redis.clients.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Connection;

import java.beans.Statement;

/**
 * Created by meng li on 2017/4/10.
 */
public class LogThreadLocal {

    //存储当前cmd信息
    private static ThreadLocal<LogDataModel> threadLocal = new ThreadLocal<LogDataModel>();
    //logger
    private final Logger logger = LoggerFactory.getLogger(Connection.class);

    public static ThreadLocal<LogDataModel> getThreadLocal()
    {
        return threadLocal;
    }
    /**
     * 从ThreadLocal里面获取LogDataModel
     *
     * @return
     */
    public static LogDataModel getLogDataModel() {
        LogDataModel logDataModel = threadLocal.get();
        if (logDataModel == null) {
            logDataModel = new LogDataModel();
            threadLocal.set(logDataModel);
        }
        return logDataModel;
    }
}
