package com.clife.dataplatform.controller;

import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.model.ArticleType;
import com.clife.dataplatform.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("articleType")
public class ArticleTypeController extends BaseController{

    @Autowired
   private ArticleTypeService articleTypeService;

    @RequestMapping("/getAll")
    public Object getAll(){
        ArticleType articleType=this.getJSONParam(ArticleType.class);
        List<ArticleType>  articleTypes=  articleTypeService.findByAll(articleType);
        return ResponseResult.success(articleTypes,"sucess");
    }
}
