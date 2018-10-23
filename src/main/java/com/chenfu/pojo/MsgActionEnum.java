package com.chenfu.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 发送消息的动作 枚举
 */
@Getter
public enum MsgActionEnum {

    POLICE_COORDIANATE(1, "交警坐标"),
    DRIVER_COORDIANATE(2, "司机坐标"),
    POLICE_CONNECT(3,"交警连接"),
    CLIENT_CONNECT(4,"客户端连接"),
    POLICE_COORDIANATE_TO_PC(5, "发送交警坐标到PC端"),
    DRIVER_COORDIANATE_TO_PC(6, "发送司机坐标到PC端"),
    MESSION(7,"新的任务");

    public final Integer type;
    public final String content;

    MsgActionEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }
}
