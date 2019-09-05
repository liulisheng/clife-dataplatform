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
}
