package com.clife.dataplatform.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Article implements Serializable {

    /**
    * 主键
    */
    private Integer articleId;

    /**
    * 标题
    */
    private String articleTitle;

    /**
    * 文章类型id
    */
    private Integer articleTypeId;

    /**
    * 描述
    */
    private String articleDescription;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 创建人id
    */
    private Integer userId;

    /**
    * 创建人名称
    */
    private String userName;

    /**
    * 0:未审核；1:审核通过；2:删除
    */
    private String articleStatus;

    private static final long serialVersionUID = 1L;

}