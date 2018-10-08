package com.chenfu.pojo;

/**
 * @Description: 发送消息的动作 枚举
 */
public enum MsgActionEnum {

    POLICE_COORDIANATE(1, "交警坐标"),
    DRIVER_COORDIANATE(2, "司机坐标"),
    POLICE_LOGIN(3,"交警登录"),
    POLICE_COORDIANATE_TO_PC(4, "发送交警坐标到PC端"),
    DRIVER_COORDIANATE_TO_PC(4, "发送交警坐标到PC端"),
    CLIENT_CONNECT(5,"客户端连接");
    public final Integer type;
    public final String content;

    MsgActionEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
