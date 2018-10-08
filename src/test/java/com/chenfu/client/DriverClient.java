package com.chenfu.client;

import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.Driver;
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
public class DriverClient {
    @Value("${com.chenfu.address}")
    private String address;
    @Test
    public void fun() {
        DataOutputStream dos = null;
        Socket soc = null;
        InputStream ios = null;
        try {
            soc = new Socket(address,8888);
            dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.DRIVER_COORDIANATE.type);
            Driver driver = new Driver("asd",123.23,23.111,4,5,6);
            dataContent.setObject(driver);
            String json = JsonUtils.objectToJson(dataContent);
            System.out.println(json);
            dos.writeUTF(json);
            byte[] bytes = new byte[100];
            ios = soc.getInputStream();
            ios.read(bytes);
            String s = new String(bytes, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
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
