package com.clife.dataplatform.service.impl;

import com.clife.dataplatform.dao.ArticleDao;
import com.clife.dataplatform.model.Article;
import com.clife.dataplatform.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;


    @Override
    public List<Article> findAll(Article article) {
        return articleDao.findByAll(article);
    }
}
