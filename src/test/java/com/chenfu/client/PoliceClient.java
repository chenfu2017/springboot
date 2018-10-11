package com.chenfu.client;

import com.chenfu.pojo.*;
import com.chenfu.utils.JsonUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
public class PoliceClient {


    public static void main(String[] args) throws Exception{
        DataOutputStream dos = null;
        Socket soc = null;
        InputStream ios = null;
        String s =null;
        try{
            soc = new Socket("127.0.0.1",8888);
            ios= soc.getInputStream();
            dos = new DataOutputStream(soc.getOutputStream());
            byte[] bytes = new byte[1000];
            DataContent connect=new DataContent();
            Police police = new Police();
            police.setPoliceid("lisi");
            police.setPassword("123456");
            connect.setAction(MsgActionEnum.POLICE_CONNECT.type);
            connect.setObject(police);
            String json = JsonUtils.objectToJson(connect);
            System.out.println(json);
            dos.writeUTF(json);
            Thread.sleep(2000);
            ios.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE.type);
            Policemsg policemsg = new Policemsg("lisi",133.12, 123.123);
            dataContent.setObject(policemsg);
            json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            ios= soc.getInputStream();
            while (true) {
                ios.read(bytes);
                json = new String(bytes, "UTF-8");
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ios.close();
                dos.close();
                soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
