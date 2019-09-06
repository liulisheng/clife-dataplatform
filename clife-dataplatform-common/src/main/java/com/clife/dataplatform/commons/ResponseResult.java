package com.clife.dataplatform.commons;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseResult {


    public static Object success(Object data,String msg) {
        Map<String, Object> map = new LinkedHashMap();
        map.put("status", 1);
        map.put("data", data);
        map.put("msg",msg);
        return map;
    }

    public static Object success(){
        Map<String, Object> map = new LinkedHashMap();
        map.put("status", 1);
        return map;
    }
    public static Object success(String msg){
        Map<String, Object> map = new LinkedHashMap();
        map.put("status", 1);
        map.put("msg", msg);
        return map;
    }
    public static Object fail(String msg){
        Map<String, Object> map = new LinkedHashMap();
        map.put("status", -1);
        map.put("msg",msg);
        return map;
    }
    public static Object fail(Object data,String msg) {
        Map<String, Object> map = new LinkedHashMap();
        map.put("status", -1);
        map.put("data", data);
        map.put("msg",msg);
        return map;
    }
    public static Object fail(Object data) {
        Map<String, Object> map = new LinkedHashMap();
        map.put("status", -1);
        map.put("data", data);
        return map;
    }

}
