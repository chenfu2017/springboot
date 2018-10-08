/**
 * @Sharable注解 - 
 *  代表当前Handler是一个可以分享的处理器。也就意味着，服务器注册此Handler后，可以分享给多个客户端同时使用。
 *  如果不使用注解描述类型，则每次客户端请求时，必须为客户端重新创建一个新的Handler对象。
 *  如果handler是一个Sharable的，一定避免定义可写的实例变量。
 *  bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new XxxHandler());
			}
		});
 */
package com.chenfu.netty;

import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.MsgActionEnum;
import com.chenfu.utils.JsonUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class JsonServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channels= new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ChannelGroup clients= new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ChannelGroup polices = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ChannelGroup drivers= new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("from client : " + msg);
        String json = msg.substring(2);
        System.out.println(json);
        Channel currentChannel = ctx.channel();
        DataContent dataContent = JsonUtils.jsonToPojo(json, DataContent.class);
        Integer action = dataContent.getAction();
        Object object = dataContent.getObject();
        if (action == MsgActionEnum.POLICE_COORDIANATE.type) {
            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE_TO_PC.type);
            polices.add(currentChannel);
            for (Channel channel :clients) {
                channel.writeAndFlush(JsonUtils.objectToJson(dataContent));
            }
        }else if (action == MsgActionEnum.DRIVER_COORDIANATE.type) {
            dataContent.setAction(MsgActionEnum.DRIVER_COORDIANATE_TO_PC.type);
            drivers.add(currentChannel);
            for (Channel channel :clients) {
                channel.writeAndFlush(JsonUtils.objectToJson(dataContent));
            }
        } else if (action == MsgActionEnum.CLIENT_CONNECT.type) {
            clients.add(currentChannel);
        }
    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(ctx.channel());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        // 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
        ctx.channel().close();
        channels.remove(ctx.channel());
    }
}
