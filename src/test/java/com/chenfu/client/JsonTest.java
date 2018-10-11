package com.chenfu.client;

import com.chenfu.utils.JsonUtils;

public class JsonTest {

    public static void main(String[] args) {
        String str="msgasdads:{\"action\":4,\"object\":null,\"extand\":null}$";
        System.out.println(JsonUtils.findObject(str));
    }

}
