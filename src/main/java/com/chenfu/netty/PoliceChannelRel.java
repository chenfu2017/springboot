package com.chenfu.netty;


import com.google.common.collect.Maps;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.Set;
public class PoliceChannelRel {

    private final static Map<String,Channel> policeManager = Maps.newConcurrentMap();

    public static Channel getChannel(String policeid) {
        return policeManager.get(policeid);
    }

    public static void put(String policeid, Channel channel) {
        policeManager.put(policeid, channel);
    }

    public static boolean isLogin(String policeid){
        return policeManager.containsKey(policeid);
    }

    public static Set<String> getOnlinePolices(){
        return policeManager.keySet();
    }

    public static void removeByChannel(Channel channel){
        for (Map.Entry<String,Channel> entry:
             policeManager.entrySet()) {
            if (entry.getValue() == channel) {
                policeManager.remove(entry.getKey());
                return;
            }
        }
    }

}
