package com.clife.dataplatform.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserinfoService2Impl implements UserinfoService2 {
    @Override
    public void test2(){
        System.out.println("测试啊啊啊");
    }
}
