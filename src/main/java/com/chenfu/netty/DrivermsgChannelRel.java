package com.chenfu.netty;


import com.chenfu.pojo.Drivermsg;
import com.google.common.collect.Maps;
import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DrivermsgChannelRel {
    private final static Map<Drivermsg,Channel> drivermsgManager = Maps.newConcurrentMap();

    public static void put(Drivermsg drivermsg,Channel channel) {
        drivermsgManager.put(drivermsg,channel);
    }

    public static Channel getChannel(Drivermsg drivermsg){
        return drivermsgManager.get(drivermsg);
    }

    public static void removeByChannel(Channel channel){
        for (HashMap.Entry<Drivermsg, Channel> entry:
                drivermsgManager.entrySet()) {
            if(channel==entry.getValue()){
                drivermsgManager.remove(entry.getKey());
                return;
            }
        }
    }

    public static Set<Drivermsg> getOnlineDrivers() {
        Set<Drivermsg> drivermsgSet = drivermsgManager.keySet();
        return drivermsgSet;
    }

}
