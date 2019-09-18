package com.clife.dataplatform.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.controller.BaseController;
import com.clife.dataplatform.upms.model.Role;
import com.clife.dataplatform.upms.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {


    @Reference
    private RoleService roleService;

    /**
     * 查询所有角色
     * @param //role
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list() {
        Role role=this.getJSONParam(Role.class);
        List<Role> list=roleService.selectByAll(role);
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return ResponseResult.success(map,"操作成功");
    }




}
