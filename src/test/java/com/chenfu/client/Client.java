package com.chenfu.client;

import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.MsgActionEnum;
import com.chenfu.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:resource.properties")
public class Client {

    @Value("${com.chenfu.address}")
    private String address;

    @Test
    public void fun(){
        try{
            Socket soc = new Socket(address,8888);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.CLIENT_CONNECT.type);
            String json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            byte[] bytes = new byte[1000];
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
