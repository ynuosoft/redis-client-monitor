package redis.clients.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meng li on 2017/4/10.
 * 记录redis 一次命令详细数据
 */
public class LogDataModel {
    /**
     * sendCommand开始时间
     */
    private long start;
    /**
     * startime -endtime 耗时
     */
    private long cost;
    /**
     * 命令名
     */
    private String cmd;
    /**
     * key值名称，按照特殊符号分词
     * 目前采用下划线"_"来分割，建议使用冒号":"更符合规范
     */
    private String key;
    /**
     * 值大小
     */
    private int size;
    /**
     * host:ip
     */
    private String server;


    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key1) {
            this.key = key1;
    }



    /**
     *
     * @param key
     * @return
     */
    StringBuilder getKeys(String key) {
        StringBuilder stringBuilder=new StringBuilder();
        String[] keySplits = key.split("[:_|]", 5);
        for (int i = 0; i < keySplits.length; i++) {
            if (keySplits[i].isEmpty()) {
                break;
            }
            stringBuilder.append("\"k"+i+"\":"+"\""+keySplits[i]+"\",");
        }
        return stringBuilder;
    }

    /**
     * 拼写成json格式
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        sb.append("\"r_start\":" + start + ",");
        sb.append( "\"r_cost\":" + cost + ",");
        sb.append("\"r_size\":" + size + ",");
        sb.append("\"r_cmd\":\"" + cmd + "\",");
        sb.append( "\"r_host\":\"" + server + "\",");
        sb.append("\"r_key\":" + "\"" + key + "\",");
        //
        sb.append("\"r_keys\":{");
        sb.append(getKeys(key));
        sb.delete(sb.length()-1,sb.length());
        sb.append("}");

        return sb.toString();

    }
}
