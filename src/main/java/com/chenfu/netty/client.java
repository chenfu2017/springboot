package com.chenfu.netty;

import com.chenfu.pojo.*;
import com.chenfu.utils.JsonUtils;

import java.net.*;
import java.io.*;
public class client {
//    public static void main(String[] args) {
//        try{
//            Socket soc = new Socket("127.0.0.1",8888);
//            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
//            DataContent dataContent = new DataContent();
//            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE.type);
//            Coordinate coordinate = new Coordinate(133, 123);
//            dataContent.setObject(coordinate);
//            String json = JsonUtils.objectToJson(dataContent);
//            System.out.println(json);
//            dos.writeUTF(json);
//            byte[] bytes = new byte[100];
//            InputStream dataIutputStream = soc.getInputStream();
//            dataIutputStream.read(bytes);
//            String s = new String(bytes, "UTF-8");
//            System.out.println(s);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        DataContent dataContent = new DataContent();
        dataContent.setAction(MsgActionEnum.DRIVER_COORDIANATE.type);
        Driver driver = new Driver("qweqw", 132.123, 213, 23, 45, 67);
        dataContent.setObject(driver);
        String json = JsonUtils.objectToJson(dataContent);
        System.out.println(json);
    }
}
