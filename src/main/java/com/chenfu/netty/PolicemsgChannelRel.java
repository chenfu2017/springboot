package com.chenfu.netty;

import com.chenfu.pojo.Policemsg;
import com.google.common.collect.Maps;
import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PolicemsgChannelRel {

    private final static Map<Policemsg,Channel> policemsgManager = Maps.newConcurrentMap();

    public static void put(Policemsg policemsg,Channel channel) {
        policemsgManager.put(policemsg,channel);
    }

    public static Channel getChannel(Policemsg policemsg){
        return policemsgManager.get(policemsg);
    }
    
    public static void removeByChannel(Channel channel){
        for (HashMap.Entry<Policemsg, Channel> entry:
             policemsgManager.entrySet()) {
            if(channel==entry.getValue()){
                policemsgManager.remove(entry.getKey());
                return;
            }
        }
    }

    public static Set<Policemsg> getOnlinePolices() {
        Set<Policemsg> policeSet = policemsgManager.keySet();
        return policeSet;
    }
    

}
