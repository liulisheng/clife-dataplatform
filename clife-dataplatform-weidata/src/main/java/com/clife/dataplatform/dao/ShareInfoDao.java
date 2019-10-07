package com.clife.dataplatform.dao;

import com.clife.dataplatform.model.ShareInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShareInfoDao {
    int deleteByPrimaryKey(Integer siId);

    int insert(ShareInfo record);

    int insertSelective(ShareInfo record);

    ShareInfo selectByPrimaryKey(Integer siId);

    int updateByPrimaryKeySelective(ShareInfo record);

    int updateByPrimaryKey(ShareInfo record);
}