package com.clife.dataplatform.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ArticleContext implements Serializable {
    /**
    * 文章id
    */
    private Integer articleId;

    /**
    * 文章内容
    */
    private String articleContext;

    private static final long serialVersionUID = 1L;
}