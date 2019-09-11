package com.clife.dataplatform.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.upms.model.Permission;
import com.clife.dataplatform.upms.model.User;
import com.clife.dataplatform.upms.service.PermissionService;
import com.clife.dataplatform.upms.vo.Menuvo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Reference
    private PermissionService permissionService;

    @RequestMapping("/getAllMenu")
    @CrossOrigin
    @RequiresPermissions("role:view")//权限管理;
    public Object getAllMenu(){
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        List<Permission> permissions=permissionService.selectByUserId(user.getUserId());
        List<Menuvo>  menuvos=recursionMenu(permissions,0);
        return ResponseResult.success(menuvos,"操作成功");
    }

    /**
     * 递归设置菜单
     * @param permissions
     * @param parentId
     * @return
     */
    public List<Menuvo> recursionMenu(List<Permission> permissions,Integer parentId){
        List<Menuvo> menuvos=new ArrayList<>();
        Menuvo   menuvo;
        for(Permission permission:permissions){
            if(parentId!=null && parentId.equals(permission.getParentId())){
                menuvo=new Menuvo();
                List<Menuvo> childrens= recursionMenu( permissions,permission.getPermissionId());
                menuvo.setId(permission.getPermissionId());
                menuvo.setResIcon(permission.getResourceIcon());
                menuvo.setResName(permission.getPermissionName());
                menuvo.setResKey(permission.getUrl());
                menuvo.setChildren(childrens);
                menuvos.add(menuvo);
            }
        }
        return menuvos;
    }


    public void addMenu(Permission permission){

    }


}
