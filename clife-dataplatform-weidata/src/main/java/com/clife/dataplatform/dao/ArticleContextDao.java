package com.clife.dataplatform.dao;

import com.clife.dataplatform.model.ArticleContext;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleContextDao {
    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleContext record);

    int insertSelective(ArticleContext record);

    ArticleContext selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleContext record);

    int updateByPrimaryKey(ArticleContext record);
}