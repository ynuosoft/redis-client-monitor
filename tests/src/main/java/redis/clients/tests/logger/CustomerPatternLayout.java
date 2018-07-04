package redis.clients.tests.logger;

import ch.qos.logback.classic.PatternLayout;

/**
 * Created by meng li on 2017/4/12.
 */
public class CustomerPatternLayout extends PatternLayout {

    static {
        defaultConverterMap.put("ip",HostIPConvert.class.getName());
        defaultConverterMap.put("host",HostNameConvert.class.getName());
    }
}
