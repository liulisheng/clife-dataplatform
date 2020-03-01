package com.clife.dataplatform.service.impl;

import com.clife.dataplatform.dao.ArticleDao;
import com.clife.dataplatform.model.Article;
import com.clife.dataplatform.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;


    @Override
    public List<Article> findAll(Article article) {
        return articleDao.findByAll(article);
    }

    @Override
    public List<Article> getList(Article article) {
        return articleDao.getList(article);
    }

    @Override
    public Article get(Integer articleId) {
        return articleDao.selectByPrimaryKey(articleId);
    }

    @Override
    public int save(Article article) {
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setArticleStatus("0");
        return articleDao.insert(article);
    }
}
