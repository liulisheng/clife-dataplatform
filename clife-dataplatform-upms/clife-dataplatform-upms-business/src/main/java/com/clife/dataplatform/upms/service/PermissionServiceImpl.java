package com.clife.dataplatform.upms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.clife.dataplatform.upms.dao.PermissionDao;
import com.clife.dataplatform.upms.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selectByUserId(Integer userId){
       return permissionDao.selectByUserId(userId);
    }

    @Override
    public List<Permission> selectByAll(Permission permission) {
        return permissionDao.selectByAll(permission);
    }


}
