package com.clife.dataplatform.controller;

import com.clife.dataplatform.restremplate.UserinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("usercenter")
public class UserInfoController {
    private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserinfoService userinfoService;
//    @RequestMapping("/login")
//    @ResponseBody
//    public Object login(@RequestBody Userinfo userinfo) {
//        Userinfo u= userinfoService.selectByPrimaryKey(1);
//
//        String ticket="ticket";
//        String token="1111";
//        String msg="操作成功";
//        Map<String,Object> map=new HashMap<>();
//        map.put("ticket",ticket);
//        map.put("token",token);
//        return ResponseResult.success(map,msg);
//    }
    @RequestMapping("/login")
    public Object hi(Integer id){
      return   userinfoService.sayHiFromClientOne(id);
    }

}
