package com.clife.dataplatform.upms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.controller.BaseController;
import com.clife.dataplatform.upms.model.User;
import com.clife.dataplatform.upms.model.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("usercenter")
public class UserController extends BaseController {

    @RequestMapping(value = "/login")
    @ResponseBody
    @CrossOrigin
    public Object login(){
        User user=this.getJSONParam(User.class);

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return ResponseResult.fail("登录失败，用户名或密码错误！");
        }

        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        Map<String,String> map=new HashMap<>();
        map.put("token",sessionId);
        map.put("ticket","ticket");
        return ResponseResult.success(map,"登录成功！");
    }


    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(){
        SecurityUtils.getSubject().logout();
        return ResponseResult.success("退出成功！");
    }

    @RequestMapping("/unauth")
    public Object unauth(){
        return ResponseResult.success("未登录！");
    }


    @RequestMapping("/userInfo")
    @ResponseBody
    public Object getUserInfo(){
        String json=" {\n" +
                "    id: 1,\n" +
                "    username: 'admin',\n" +
                "    password: '121212',\n" +
                "    chineseName: '管理员',\n" +
                "    idcardNo: '000000000000000000',\n" +
                "    policeCode: '000000',\n" +
                "    deptCode: '370200000000',\n" +
                "    gender: 1,\n" +
                "    email: 'abc@abc.com',\n" +
                "    phoneNo: '15100000005',\n" +
                "    duty: '超级管理员',\n" +
                "    address: 'address',\n" +
                "    remark: 'remarl',\n" +
                "    type: 0,\n" +
                "    status: 0,\n" +
                "    roles: [\n" +
                "      {\n" +
                "        id: 1,\n" +
                "        roleName: '超级管理员',\n" +
                "        resources: [],\n" +
                "      },\n" +
                "    ],\n" +
                "    deptName: '杭州市',\n" +
                "    ticket: '.2XxGlEuidOmAoYIdSo6pQIlGbQSh83U7p4eJsoTO-70',\n" +
                "    gxdwdm: '370200000000',\n" +
                "    deptLevel: '1',\n" +
                "    defaultDeptCode: '370200000000',\n" +
                "    defaultXzqhCode: '370200',\n" +
                "  }";
        UserInfo userInfo= JSON.toJavaObject( JSONObject.parseObject(json),UserInfo.class);
        return ResponseResult.success(userInfo,"获取成功");
    }
}
