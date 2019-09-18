package com.clife.dataplatform.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.controller.BaseController;
import com.clife.dataplatform.upms.model.Permission;
import com.clife.dataplatform.upms.model.Role;
import com.clife.dataplatform.upms.model.User;
import com.clife.dataplatform.upms.service.PermissionService;
import com.clife.dataplatform.upms.vo.Menuvo;
import com.clife.dataplatform.upms.vo.PermissionVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Reference
    private PermissionService permissionService;


    /**
     * 获取菜单
     * @return
     */
    @RequestMapping("/getAllMenu")
    @RequiresPermissions("role:view")
    public Object getAllMenu(){
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        List<Permission> permissions=permissionService.selectByUserId(user.getUserId());
        List<Menuvo>  menuvos=recursionMenu(permissions,0);
        Map<String,Object> map=new HashMap<>();
        map.put("list",menuvos);
        return ResponseResult.success(map,"操作成功");
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


    /**
     * 权限管理列表
     */
    @RequestMapping("/getPermissions")
    @CrossOrigin
   // @RequiresPermissions("role:view")
    public Object getPermissions(){
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        List<Permission> permissions=permissionService.selectByUserId(user.getUserId());
        List<PermissionVo> list=recursionPermission(permissions,0);
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return ResponseResult.success(map,"操作成功");
    }

    public void addMenu(Permission permission){

    }

    /**
     * 递归设置菜单
     * @param permissions
     * @param parentId
     * @return
     */
    public List<PermissionVo> recursionPermission(List<Permission> permissions,Integer parentId){
        List<PermissionVo> permissionVos=new ArrayList<>();
        PermissionVo   permissionVo;
        for(Permission permission:permissions){
            if(parentId!=null && parentId.equals(permission.getParentId())){
                permissionVo=new PermissionVo();
                List<PermissionVo> childrens= recursionPermission( permissions,permission.getPermissionId());
                BeanUtils.copyProperties(permission,permissionVo);
                permissionVo.setChildren(childrens);
                permissionVos.add(permissionVo);
            }
        }
        return permissionVos;
    }


    /**
     * 添加菜单
     */
    @RequestMapping("/addPermission")
    public Object add(){
        Permission permission=getJSONParam(Permission.class);
        permissionService.insert(permission);
        return  ResponseResult.success("操作成功");

    }


    /**
     * 获取菜单详情
     * @param //permissionId
     * @return
     */
    @RequestMapping("/detail")
    public Object getPermission(){
        Permission permission=getJSONParam(Permission.class);
        Permission detail=permissionService.selectByPrimaryKey(permission.getPermissionId());
        return ResponseResult.success(detail,"操作成功");

    }

    /**
     * 更新权限
     * @return
     */
    @RequestMapping("/update")
    public Object update(){
        Permission permission=getJSONParam(Permission.class);
        permissionService.updateByPrimaryKey(permission);
        return ResponseResult.success("操作成功");
    }

    /**
     * 更新权限
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(){
        Permission permission=getJSONParam(Permission.class);
        permissionService.deleteByPrimaryKey(permission.getPermissionId());
        return ResponseResult.success("操作成功");
    }


    /**
     * 更新状态
     * @return
     */
    @RequestMapping("/updateStatus")
    public Object updateStatus(){
        Permission permission=getJSONParam(Permission.class);
        permissionService.updateByPrimaryKeySelective(permission);
        return ResponseResult.success("操作成功");
    }


    /**
     * 根据角色获取菜单
     * @return
     */
    @RequestMapping("/getPermissionsByRoleId")
    @ResponseBody
    public Object getPermissionByRoleId(){
        Role role=this.getJSONParam(Role.class);
        List<Permission> permissions=permissionService.getPermissionByRoleId(role.getRoleId());
        Map<String,Object> map=new HashMap<>();
        List<PermissionVo> list=recursionPermission(permissions,0);
        map.put("list",list);
        return ResponseResult.success(map,"操作成功");
    }

}
