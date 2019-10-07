package com.clife.dataplatform.service;

import com.clife.dataplatform.model.ArticleType;

import java.util.List;

public interface ArticleTypeService {

    public int save(ArticleType articleType);

    public List<ArticleType> findByAll(ArticleType articleType);

}
