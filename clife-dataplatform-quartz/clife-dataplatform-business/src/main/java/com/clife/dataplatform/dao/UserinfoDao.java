package com.clife.dataplatform.dao;

import com.clife.dataplatform.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserinfoDao {


    Userinfo selectByPrimaryKey(@Param("id") Integer id);


}