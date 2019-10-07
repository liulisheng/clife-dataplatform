package com.clife.dataplatform.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class ShareInfo implements Serializable {
    private Integer siId;

    private Date createTime;

    private Date updateTime;

    private Boolean delFlag;

    private String siContent;

    private Boolean siStatus;

    private Integer userId;

    private String userName;

    private static final long serialVersionUID = 1L;
}