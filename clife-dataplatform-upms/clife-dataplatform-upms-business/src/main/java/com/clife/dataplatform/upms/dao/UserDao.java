package com.clife.dataplatform.upms.dao;

import com.clife.dataplatform.upms.model.User;import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(@Param("userName") String userName);
}