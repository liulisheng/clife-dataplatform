package com.clife.dataplatform.dao;

import com.clife.dataplatform.model.ArticleType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ArticleTypeDao {
    int deleteByPrimaryKey(Integer articleTypeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Integer articleTypeId);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);

    List<ArticleType> findByAll(ArticleType articleType);
}