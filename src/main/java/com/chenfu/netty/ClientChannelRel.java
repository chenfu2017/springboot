package com.chenfu.netty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.netty.channel.Channel;

/**
 * @Description: 用户id和channel的关联关系处理
 */
public class ClientChannelRel {

	private static List<Channel> manager = new ArrayList<>();

    public static void add(Channel channel) {
        manager.add(channel);
    }

    public static void remove(Channel channel) {
        manager.remove(channel);
    }
}
