package com.chenfu.netty;


import com.chenfu.pojo.Drivermsg;
import com.google.common.collect.Maps;
import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DriverChannelRel {
    private final static Map<String,Channel> drivermsgManager = Maps.newConcurrentMap();

    public static void put(String driverid,Channel channel) {
        drivermsgManager.put(driverid,channel);
    }

    public static Channel getChannel(String driverid){
        return drivermsgManager.get(driverid);
    }

    public static void removeByChannel(Channel channel){
        for (HashMap.Entry<String, Channel> entry:
                drivermsgManager.entrySet()) {
            if(channel==entry.getValue()){
                drivermsgManager.remove(entry.getKey());
                return;
            }
        }
    }

    public static Set<String> getOnlineDrivers() {
        Set<String> driverSet = drivermsgManager.keySet();
        return driverSet;
    }

}
