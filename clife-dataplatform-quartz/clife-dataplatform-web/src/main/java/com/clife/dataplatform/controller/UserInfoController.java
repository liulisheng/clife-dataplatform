package com.clife.dataplatform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.model.Userinfo;
import com.clife.dataplatform.service.UserinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("usercenter")
public class UserInfoController {
    private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Reference(
            version = "${hello.service.version}"
    )
    private UserinfoService userinfoService;
    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Userinfo userinfo) {
       // Userinfo userinfo= userinfoService.selectByPrimaryKey(1);

        String ticket="ticket";
        String token="1111";
        String msg="操作成功";
        Map<String,Object> map=new HashMap<>();
        map.put("ticket",ticket);
        map.put("token",token);
        return ResponseResult.success(map,msg);
    }

}
