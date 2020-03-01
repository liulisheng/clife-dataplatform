package com.clife.dataplatform.controller;

import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.model.Article;
import com.clife.dataplatform.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController  extends BaseController{

    @Resource
    private ArticleService articleService;

    @RequestMapping("/getList")
    public Object getList(){
        Article articleType=this.getJSONParam(Article.class);
        List<Article> articles=  articleService.getList(articleType);
        return ResponseResult.success(articles,"sucess");
    }

    @RequestMapping("/get")
    public Object get(Integer articleId){
        Article article=  articleService.get(articleId);
        return ResponseResult.success(article,"sucess");
    }


    @RequestMapping("/add")
    public Object add(Integer articleId){
        Article articleType=this.getJSONParam(Article.class);
        articleService.save(articleType);
        return ResponseResult.success("sucess");
    }


}
