package com.clife.dataplatform.upms.dao;

import com.clife.dataplatform.upms.model.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionDao {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}