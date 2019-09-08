package com.clife.dataplatform.upms.service;

import com.clife.dataplatform.upms.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> selectByUserId(Integer userId);

    List<Permission> selectByAll(Permission permission);


}
