package com.clife.dataplatform.service;


import com.clife.dataplatform.dao.UserinfoDao;
import com.clife.dataplatform.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    UserinfoService2 userinfo2;

    @Override
    @RequestMapping("/hi")
    public Userinfo selectByPrimaryKey(Integer id) {
        System.out.println("dubbo 远程调用");
        userinfo2.test2();
        return userinfoDao.selectByPrimaryKey(id);
    }
}
