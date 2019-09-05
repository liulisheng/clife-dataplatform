package com.clife.dataplatform.upms.dao;

import com.clife.dataplatform.upms.model.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}