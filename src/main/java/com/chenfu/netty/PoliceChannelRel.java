package com.chenfu.netty;

import java.util.HashMap;

import io.netty.channel.Channel;

/**
 * @Description: 用户id和channel的关联关系处理
 */
public class PoliceChannelRel {

	private static HashMap<String, Channel> polices = new HashMap<>();

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
}
