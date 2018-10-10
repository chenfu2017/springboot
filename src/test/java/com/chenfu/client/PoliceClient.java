package com.chenfu.client;

import com.chenfu.pojo.Coordinate;
import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.MsgActionEnum;
import com.chenfu.pojo.Police;
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
        try{
            soc = new Socket("127.0.0.1",8888);
            ios= soc.getInputStream();
            dos = new DataOutputStream(soc.getOutputStream());
            DataContent connect=new DataContent();
            Police police = new Police();
            police.setPoliceid("police");
            police.setPassword("123456");
            connect.setAction(MsgActionEnum.POLICE_CONNECT.type);
            connect.setObject(police);
            String json = JsonUtils.objectToJson(connect);
//            System.out.println(json);
            dos.writeUTF(json);
            Thread.sleep(2000);
            byte[] bytes = new byte[1000];
            ios.read(bytes);
            String s = new String(bytes, "UTF-8");
            System.out.println(s);
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE.type);
            Coordinate coordinate = new Coordinate("police",133.12, 123.123);
            dataContent.setObject(coordinate);
            json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            ios= soc.getInputStream();
            while (true) {
                ios.read(bytes);
                s = new String(bytes, "UTF-8");
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
