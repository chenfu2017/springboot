package com.chenfu.netty;

import java.util.HashMap;

public class MessionMap {

    private static HashMap<String, String> tasks = new HashMap<>();

    public static void add(String driverId,String policeId){
        tasks.put(driverId,policeId);
    }

    public static boolean isIllegitimate(String driverId){
        return tasks.containsKey(driverId);
    }

    public static String getPoliceId(String driverId){
        return tasks.get(driverId);
    }


}
