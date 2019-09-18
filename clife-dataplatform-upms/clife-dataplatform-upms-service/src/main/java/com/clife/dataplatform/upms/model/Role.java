package com.clife.dataplatform.upms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Role implements Serializable {
    private Integer roleId;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private String description;

    private Boolean delFlag;

    private String roleCode;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}