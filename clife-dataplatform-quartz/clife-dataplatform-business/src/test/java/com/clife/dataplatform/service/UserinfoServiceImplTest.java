package com.clife.dataplatform.service;

import com.clife.dataplatform.BusinessBootstrap;
import com.clife.dataplatform.model.Userinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BusinessBootstrap.class})// 指定启动类
public class UserinfoServiceImplTest {

    private final static Logger logger = LoggerFactory.getLogger(UserinfoServiceImplTest.class);
    @Resource
    UserinfoService userinfoService;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void selectByPrimaryKey() {
        Userinfo userinfo=  userinfoService.selectByPrimaryKey(1);
        logger.info("测试成功1");
    }
}