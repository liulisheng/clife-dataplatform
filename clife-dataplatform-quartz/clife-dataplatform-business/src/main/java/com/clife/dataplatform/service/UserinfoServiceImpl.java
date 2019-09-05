package com.clife.dataplatform.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.clife.dataplatform.dao.UserinfoDao;
import com.clife.dataplatform.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;


@Service(
        version = "${hello.service.version}"
)
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    UserinfoService2 userinfo2;
    @Override
    public Userinfo selectByPrimaryKey(Integer id) {
        System.out.println("dubbo 远程调用");
        userinfo2.test2();
        return userinfoDao.selectByPrimaryKey(id);
    }
}
