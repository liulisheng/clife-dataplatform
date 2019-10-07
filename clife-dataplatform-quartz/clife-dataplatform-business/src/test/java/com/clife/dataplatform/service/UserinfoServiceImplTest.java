//package com.clife.dataplatform.service;
//
//import com.clife.dataplatform.BusinessBootstrap;
//import com.clife.dataplatform.utils.RedisUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//;
//
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {BusinessBootstrap.class})// 指定启动类
//public class UserinfoServiceImplTest {
//
//    private final static Logger logger = LoggerFactory.getLogger(UserinfoServiceImplTest.class);
//    @Resource
//    UserinfoService userinfoService;
//
//
//    @Resource
//    private RedisUtils redisUtils;
//
//
//    @Test
//    public void selectByPrimaryKey() {
//        redisUtils.set("A:test:object","1");
//        Object object=redisUtils.get("A:test:object");
//        System.out.println(object);
////        Userinfo userinfo=  userinfoService.selectByPrimaryKey(1);
//        logger.info("测试成功1");
//
//        Map<String, Object> map=new HashMap<>();
//        map.put("String1","value");
//       map.put("int1",1);
//        redisUtils.hmset("A:test:map",map);
//        Map<Object,Object> map2= redisUtils.hmget("A:test:map");
//        Integer int1= (Integer) map2.get("int1");
//        String string1= (String) map2.get("String1");
//        logger.info("string1:"+string1);
//        logger.info("测试成功2");
//    }
//
//}