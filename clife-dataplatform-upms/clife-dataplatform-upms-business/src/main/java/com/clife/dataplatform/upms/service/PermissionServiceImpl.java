package com.clife.dataplatform.upms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.clife.dataplatform.upms.dao.PermissionDao;
import com.clife.dataplatform.upms.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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


    /**
     * 默认admin账号分配权限
     * @param permission
     * @return
     */
    @Override
    @Transactional
    public int insert(Permission permission) {
        permissionDao.insertSelective(permission);
        permissionDao.insertRolePermission(permission.getPermissionId(),1);
        return 0;
    }

    @Override
    public Permission selectByPrimaryKey(Integer permissionId) {
        return permissionDao.selectByPrimaryKey(permissionId);
    }

    @Override
    public int updateByPrimaryKey(Permission permission) {
        return permissionDao.updateByPrimaryKey(permission);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer permissionId) {
        permissionDao.deleteByPrimaryKey(permissionId);
        permissionDao.deleteRolePermByPerId(permissionId);
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Permission> getPermissionByRoleId(Integer roleId) {
        return permissionDao.getPermissionByRoleId(roleId);
    }


}
