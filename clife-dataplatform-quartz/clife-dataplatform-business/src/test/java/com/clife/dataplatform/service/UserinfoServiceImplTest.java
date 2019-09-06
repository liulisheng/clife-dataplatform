package com.clife.dataplatform.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.clife.dataplatform.BaseTest;
import com.clife.dataplatform.model.Userinfo;
import com.clife.dataplatform.utils.RedisUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


public class UserinfoServiceImplTest extends BaseTest {

    private final static Logger logger = LoggerFactory.getLogger(UserinfoServiceImplTest.class);
    @Resource
    UserinfoService userinfoService;


    @Resource
    private RedisUtils redisUtils;


    @Test
    public void selectByPrimaryKey() {
        redisUtils.set("A:test:object","1");
        Object object=redisUtils.get("A:test:object");
        System.out.println(object);
//        Userinfo userinfo=  userinfoService.selectByPrimaryKey(1);
        logger.info("测试成功1");

        Map<String, Object> map=new HashMap<>();
        map.put("String1","value");
       map.put("int1",1);
        redisUtils.hmset("A:test:map",map);
        Map<Object,Object> map2= redisUtils.hmget("A:test:map");
        Integer int1= (Integer) map2.get("int1");
        String string1= (String) map2.get("String1");
        logger.info("string1:"+string1);
        logger.info("测试成功2");
    }

}