package com.chenfu.client;

import com.chenfu.pojo.Coordinate;
import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.MsgActionEnum;
import com.chenfu.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:resource.properties")
public class PoliceClient {
    @Value("${com.chenfu.address}")
    private String address;
    @Test
    public void fun() {
        DataOutputStream dos = null;
        Socket soc = null;
        InputStream ios = null;
        try{
            soc = new Socket(address,8888);
            dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.POLICE_COORDIANATE.type);
            Coordinate coordinate = new Coordinate("qewwe",133, 123);
            dataContent.setObject(coordinate);
            String json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            ios= soc.getInputStream();
            byte[] bytes = new byte[1000];
            ios.read(bytes);
            String s = new String(bytes, "UTF-8");
            System.out.println(s);

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

//    public static void main(String[] args) {
//        try{
//            Socket soc = new Socket("120.78.150.161",8888);
////            Socket soc = new Socket("127.0.0.1",8888);
//            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
//            DataContent dataContent = new DataContent();
//            dataContent.setAction(MsgActionEnum.POLICE_LOGIN.type);
//            Police police = new Police();
//            police.setPoliceId("123");
//            police.setPassword("asd");
//            dataContent.setObject(police);
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

}
