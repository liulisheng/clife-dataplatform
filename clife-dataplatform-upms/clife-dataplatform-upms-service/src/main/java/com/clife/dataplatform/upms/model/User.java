package com.clife.dataplatform.upms.model;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userPhone;

    private Boolean userSex;

    private Date createTime;

    private Date updateTime;

    private Boolean delFlag;

    private static final long serialVersionUID = 1L;


}