package com.clife.dataplatform.service;

import com.clife.dataplatform.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll(Article article);
}
