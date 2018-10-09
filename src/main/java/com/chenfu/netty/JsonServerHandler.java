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

import com.chenfu.pojo.*;
import com.chenfu.utils.JsonUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JsonServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup clients= new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("msg:{}",msg);
        String json = msg.substring(2);
        String strObject = JsonUtils.findObject(json);
        Channel currentChannel = ctx.channel();
        DataContent dataContent = null;
        try {
            dataContent = JsonUtils.jsonToPojo(json, DataContent.class);
            if (dataContent == null) {
                currentChannel.writeAndFlush("JOSN CONVERT ERROR");
                return;
            }
        } catch (Exception e) {
            log.error("exception e:{}",e);
            currentChannel.writeAndFlush("JOSN CONVERT ERROR");
            return;
        }
        Integer action = dataContent.getAction();
        if (action == MsgActionEnum.POLICE_COORDIANATE.type) {
            log.info("from Police:{} ",json);
            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE_TO_PC.type);
            for (Channel channel :clients) {
                channel.writeAndFlush(JsonUtils.objectToJson(dataContent));
            }
        }else if (action == MsgActionEnum.DRIVER_COORDIANATE.type) {
            log.info("from Driver:{} ",json);
            Driver driver = JsonUtils.jsonToPojo(strObject, Driver.class);
            String driverId = driver.getDriverId();
            dataContent.setAction(MsgActionEnum.DRIVER_COORDIANATE_TO_PC.type);
            DriverChannelRel.put(driverId,currentChannel);
            for (Channel channel :clients) {
                channel.writeAndFlush(JsonUtils.objectToJson(dataContent));
            }
            if(Mission.isIllegitimate(driverId)){
                String policeId = Mission.getPoliceId(driverId);
                Channel policeChannel = PoliceChannelRel.get(policeId);
                if (policeChannel==null){
                    for (Channel channel :clients) {
                        channel.writeAndFlush("police:"+policeId+"not online!");
                    }
                } else {
                    policeChannel.writeAndFlush(JsonUtils.objectToJson(dataContent));
                }
            }
        } else if (action == MsgActionEnum.CLIENT_CONNECT.type) {
            log.info("from Client:{}",json);
            currentChannel.writeAndFlush("SUCCRSS");
            clients.add(currentChannel);
        } else if (action == MsgActionEnum.POLICE_CONNECT.type) {
            Police police = JsonUtils.jsonToPojo(strObject, Police.class);
            String policeId = police.getPoliceId();
            System.out.println(policeId);
            PoliceChannelRel.put(policeId,currentChannel);
            currentChannel.writeAndFlush("SUCCESS");
        } else if (action==MsgActionEnum.MESSION.type){
            log.info("a mession add.{}",json);
            TakeAction takeAction = JsonUtils.jsonToPojo(strObject,TakeAction.class);
            String policeId = takeAction.getPoliceId();
            String driverId = takeAction.getDriverId();
            Mission.add(driverId,policeId);
            currentChannel.writeAndFlush("SUCCESS");
        }
    }

}
