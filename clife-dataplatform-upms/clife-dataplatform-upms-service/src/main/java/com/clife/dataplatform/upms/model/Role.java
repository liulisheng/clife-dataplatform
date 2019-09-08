package com.clife.dataplatform.upms.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private static final long serialVersionUID = 1L;
}