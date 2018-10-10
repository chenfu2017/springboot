package com.chenfu.client;

import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.Driver;
import com.chenfu.pojo.DriverVo;
import com.chenfu.pojo.MsgActionEnum;
import com.chenfu.utils.JsonUtils;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class DriverClient {


    public static void main(String[] args) {
        try {
            Socket soc = new Socket("127.0.0.1",8888);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.DRIVER_COORDIANATE.type);
            Driver driver = new Driver("driver",4,5,6);
            DriverVo driverVo = new DriverVo(driver,123.123,11.111);
            dataContent.setObject(driverVo);
            String json = JsonUtils.objectToJson(dataContent);
//            System.out.println(json);
            dos.writeUTF(json);
            byte[] bytes = new byte[100];
            InputStream ios = soc.getInputStream();
            ios.read(bytes);
            String s = new String(bytes, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
