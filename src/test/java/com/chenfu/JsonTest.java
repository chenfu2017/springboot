package com.chenfu;

import com.chenfu.pojo.DataContent;
import com.chenfu.pojo.Police;
import com.chenfu.utils.JsonUtils;

public class JsonTest {

    public static void main(String[] args) {
        DataContent dataContent = new DataContent();
        dataContent.setAction(1);
        Police police = new Police();
        police.setPoliceId("123123");
        police.setPassword("qqqqqq");
        dataContent.setObject(police);
//         dataContent.setObject(driver);
        String json = JsonUtils.objectToJson(dataContent);
        System.out.println(json);
        DataContent dataContent1 = JsonUtils.jsonToPojo(json, DataContent.class);
        Police police1 = JsonUtils.jsonToPojo(JsonUtils.findObject(json), Police.class);
        System.out.println(dataContent1);
        System.out.println(police1.getPoliceId());
    }
}
