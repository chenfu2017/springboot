package com.chenfu.netty.client;

import com.chenfu.pojo.Coordinate;
import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.MsgActionEnum;
import com.chenfu.utils.JsonUtils;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket soc = new Socket("127.0.0.1",8888);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.CLIENT_CONNECT.type);
            String json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            byte[] bytes = new byte[100];
            InputStream dataIutputStream = soc.getInputStream();
            while (true) {
                dataIutputStream.read(bytes);
                String s = new String(bytes, "UTF-8");
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
