package com.clife.dataplatform.upms.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userPhone;

    private Boolean userSex;

    private Date createTime;

    private Date updateTime;

    private Boolean delFlag;

    private String userSalt;

    private static final long serialVersionUID = 1L;
}