package com.clife.dataplatform.service.impl;

import com.clife.dataplatform.dao.ArticleTypeDao;
import com.clife.dataplatform.model.ArticleType;
import com.clife.dataplatform.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
   @Autowired
    private ArticleTypeDao articleTypeDao;


    @Override
    public int save(ArticleType articleType) {
        return articleTypeDao.insert(articleType);
    }

    @Override
    public List<ArticleType> findByAll(ArticleType articleType) {
        return articleTypeDao.findByAll(articleType);
    }




}
