package com.clife.dataplatform.upms.controller;

import com.clife.dataplatform.commons.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String userName, @RequestParam String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return ResponseResult.fail("登录失败，用户名或密码错误！");
        }
        return ResponseResult.success("登录成功！");
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

    @Component
    public static class SpringUtil implements ApplicationContextAware {

        private static ApplicationContext context;
        /**
         * Spring在bean初始化后会判断是不是ApplicationContextAware的子类
         * 如果该类是,setApplicationContext()方法,会将容器中ApplicationContext作为参数传入进去
         * @Author Sans
         * @CreateTime 2019/6/17 16:58
         */
        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            context = applicationContext;
        }
        /**
         * 通过Name返回指定的Bean
         * @Author Sans
         * @CreateTime 2019/6/17 16:03
         */
        public static <T> T getBean(Class<T> beanClass) {
            return context.getBean(beanClass);
        }


    }
}
