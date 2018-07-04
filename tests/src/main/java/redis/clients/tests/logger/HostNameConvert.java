package redis.clients.tests.logger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by meng li on 2017/4/12.
 */
public class HostNameConvert extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        try {
           return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {

        }
        return null;
    }
}
