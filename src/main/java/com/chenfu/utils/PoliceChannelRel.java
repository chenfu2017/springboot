package com.chenfu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

/**
 * @Description: 用户policeid和channel的关联关系处理
 */
public class PoliceChannelRel {

    private static ConcurrentHashMap<String, Channel> polices = new ConcurrentHashMap<>();

	public static void put(String senderId, Channel channel) {
        polices.put(senderId, channel);
	}
	
	public static Channel get(String senderId) {
		return polices.get(senderId);
	}
	
	public static void output() {
		for (HashMap.Entry<String, Channel> entry : polices.entrySet()) {
			System.out.println("policeId: " + entry.getKey()
							+ ", ChannelId: " + entry.getValue().id().asLongText());
		}
	}

    public static Set<String> getAllPoliceid() {
	    List<String> list = new ArrayList<>();
        Set<String> policeids = polices.keySet();
        return policeids;
    }
}
