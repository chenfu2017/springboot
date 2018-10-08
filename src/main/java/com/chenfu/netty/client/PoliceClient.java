package com.chenfu.netty.client;

import com.chenfu.pojo.*;
import com.chenfu.utils.JsonUtils;
import org.junit.jupiter.api.Test;

import java.net.*;
import java.io.*;
public class PoliceClient {
    public static void main(String[] args) {
        try{
            Socket soc = new Socket("127.0.0.1",8888);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE.type);
            Coordinate coordinate = new Coordinate("qewwe",133, 123);
            dataContent.setObject(coordinate);
            String json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            InputStream dataIutputStream = soc.getInputStream();
            byte[] bytes = new byte[100];
            dataIutputStream.read(bytes);
            String s = new String(bytes, "UTF-8");
            System.out.println(s);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void fun() throws IOException {
        Socket soc = new Socket("127.0.0.1",8888);
        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        DataContent dataContent = new DataContent();
        dataContent.setAction(MsgActionEnum.POLICE_LOGIN.type);
        Police police = new Police();
        police.setPoliceId("213");
        police.setPassword("root");
        dataContent.setObject(police);
        String s = JsonUtils.objectToJson(dataContent);
        dos.writeUTF(s);
    }

}
