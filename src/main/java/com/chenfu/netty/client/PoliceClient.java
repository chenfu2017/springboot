package com.chenfu.netty.client;

import com.chenfu.pojo.*;
import com.chenfu.utils.JsonUtils;

import java.net.*;
import java.io.*;
public class PoliceClient {
//    public static void main(String[] args) {
//        try{
//            Socket soc = new Socket("127.0.0.1",8888);
//            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
//            DataContent dataContent = new DataContent();
//            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE.type);
//            Coordinate coordinate = new Coordinate("qewwe",133, 123);
//            dataContent.setObject(coordinate);
//            String json = JsonUtils.objectToJson(dataContent);
//            System.out.println(json);
//            dos.writeUTF(json);
//            InputStream dataIutputStream = soc.getInputStream();
//            byte[] bytes = new byte[100];
//            dataIutputStream.read(bytes);
//            String s = new String(bytes, "UTF-8");
//            System.out.println(s);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try{
//            Socket soc = new Socket("120.78.150.161",8888);
            Socket soc = new Socket("127.0.0.1",8888);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.POLICE_LOGIN.type);
            Police police = new Police();
            police.setPoliceId("123");
            police.setPassword("asd");
            dataContent.setObject(police);
            String json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            byte[] bytes = new byte[100];
            InputStream dataIutputStream = soc.getInputStream();
            dataIutputStream.read(bytes);
            String s = new String(bytes, "UTF-8");
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
