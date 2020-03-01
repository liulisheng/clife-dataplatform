package com.clife.dataplatform.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ArticleType implements Serializable {
    /**
     * 文章类型id
     */
    private Integer articleTypeId;

    /**
     * 文章类型名称
     */
    private String tbArticleName;

    /**
     * 0:未启用；1:启用
     */
    private Boolean status;

    /**
     * 文章类型父id
     */
    private Integer articleTypePid;

    /**
     * 类型图标
     */
    private String articleTypeIcon;

    private static final long serialVersionUID = 1L;
}