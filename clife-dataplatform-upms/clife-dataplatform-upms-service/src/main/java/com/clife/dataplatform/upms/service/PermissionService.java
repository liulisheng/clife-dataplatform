package com.clife.dataplatform.upms.service;

import com.clife.dataplatform.upms.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> selectByUserId(Integer userId);

    List<Permission> selectByAll(Permission permission);


    int insert(Permission permission);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKey(Permission permission);


    int deleteByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

}
