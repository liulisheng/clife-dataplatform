package com.clife.dataplatform.upms.controller;

import com.clife.dataplatform.commons.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping("/getAllMenu")
    @RequiresPermissions("role:view")//权限管理;
    public Object getAllMenu(){

        return ResponseResult.success();
    }


}
