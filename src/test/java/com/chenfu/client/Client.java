package com.chenfu.client;

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
            dos.writeUTF(JsonUtils.objectToJson(dataContent));
            byte[] bytes = new byte[300];
            InputStream dataIutputStream = soc.getInputStream();
            dataIutputStream.read(bytes);
            String s = new String(bytes, "UTF-8");
            System.out.println(s);
//            Thread.sleep(2000);
//            DataContent mession = new DataContent();
//            mession.setAction(MsgActionEnum.MESSION.type);
//            Mession takeAction = new Mession("police","driver");
//            mession.setObject(takeAction);
//            String json = JsonUtils.objectToJson(mession);
//            System.out.println(json);
//            dos.writeUTF(json);
            while (true){
                dataIutputStream.read(bytes);
                s = new String(bytes, "UTF-8");
                System.out.println(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
