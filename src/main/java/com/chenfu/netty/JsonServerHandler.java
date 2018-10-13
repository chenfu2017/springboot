package com.chenfu.netty;

import com.chenfu.SpringUtil;
import com.chenfu.pojo.*;
import com.chenfu.service.MessionService;
import com.chenfu.service.PoliceService;
import com.chenfu.utils.JsonUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonServerHandler extends SimpleChannelInboundHandler<Object> {
    public static ChannelGroup clients= new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //业务处理函数
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message =(String)msg;
        String json = JsonUtils.findObject(message);
        String strInnerObject = JsonUtils.findInnerObject(json);
        Channel currentChannel = ctx.channel();
        DataContent dataContent = null;
        try {
            //转换JOSON
            dataContent = JsonUtils.jsonToPojo(json, DataContent.class);
            if (dataContent == null) {
                log.error("msg:{}",msg);
                log.error("json convert error!");
                JSONResult jsonResult = JSONResult.errorMsg("json convert error!");
                currentChannel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
                return;
            }
        } catch (Exception e) {
            log.error("exception e:{}",e);
            log.error("json convert error!");
            JSONResult jsonResult = JSONResult.errorMsg("json convert error!");
            currentChannel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
            return;
        }
        Integer action = dataContent.getAction();
        if (action == MsgActionEnum.POLICE_COORDIANATE.type) {
            log.info("from Police:{} ",json);
            Policemsg policemsg = JsonUtils.jsonToPojo(strInnerObject, Policemsg.class);
            if(PoliceChannelRel.isLogin(policemsg.getPoliceid())){
                dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE_TO_PC.type);
                for (Channel channel :clients) {
                    channel.writeAndFlush(JsonUtils.objectToJson(dataContent));
                }
            } else {
                JSONResult jsonResult = JSONResult.errorMsg("please login!!!");
                currentChannel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
                ctx.close();
            }
        }else if (action == MsgActionEnum.DRIVER_COORDIANATE.type) {
            log.info("from Driver:{} ",json);
            Drivermsg drivermsg = JsonUtils.jsonToPojo(strInnerObject, Drivermsg.class);
            DriverChannelRel.put(drivermsg.getDriverid(),currentChannel);
            dataContent.setAction(MsgActionEnum.DRIVER_COORDIANATE_TO_PC.type);
            for (Channel channel :clients) {
                channel.writeAndFlush(JsonUtils.objectToJson(dataContent));
            }
            MessionService messionService = SpringUtil.getBean(MessionService.class);
            String driverid=drivermsg.getDriverid();
            String policeid = messionService.getPoliceid(driverid);
            if (policeid != null) {
                Channel policeChannel = PoliceChannelRel.getChannel(policeid);
                if (policeChannel==null){
                    for (Channel channel :clients) {
                        JSONResult jsonResult = JSONResult.errorMsg("police:" + policeid + "not online!");
                        channel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
                    }
                } else {
                    policeChannel.writeAndFlush(JsonUtils.objectToJson(dataContent));
                }
            }
        } else if (action == MsgActionEnum.CLIENT_CONNECT.type) {
            log.info("from Client:{}",json);
            JSONResult jsonResult = JSONResult.ok();
            currentChannel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
            clients.add(currentChannel);
        } else if (action == MsgActionEnum.POLICE_CONNECT.type) {
            log.info("police connect:{}",json);
            Police police = JsonUtils.jsonToPojo(strInnerObject, Police.class);
            PoliceService policeService = SpringUtil.getBean(PoliceService.class);
            JSONResult jsonResult = policeService.login(police.getPoliceid(),police.getPassword());
            if(jsonResult.getStatus()==200){
                PoliceChannelRel.put(police.getPoliceid(),currentChannel);
            }
            currentChannel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
        } else if (action==MsgActionEnum.MESSION.type){
            log.info("a mession:{}",json);
            Mession mession = JsonUtils.jsonToPojo(strInnerObject,Mession.class);
            String policeid = mession.getPoliceid();
            String driverid = mession.getDriverid();
            MessionService messionService = SpringUtil.getBean(MessionService.class);
            JSONResult jsonResult = messionService.addMession(policeid, driverid);
            currentChannel.writeAndFlush(JsonUtils.objectToJson(jsonResult));
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel =ctx.channel();
        log.info("客户端被移除，channelId为:{}",channel.id().asShortText());
        PoliceChannelRel.removeByChannel(channel);
        DriverChannelRel.removeByChannel(channel);
        clients.remove(channel);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("exception:{}",cause.getMessage());
        Channel channel =ctx.channel();
        channel.close();
        PoliceChannelRel.removeByChannel(channel);
        DriverChannelRel.removeByChannel(channel);
        clients.remove(channel);
    }
}
