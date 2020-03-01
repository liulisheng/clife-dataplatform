package com.clife.dataplatform.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User implements Serializable {
    /**
     * 用户主键id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别？0:女；1:男
     */
    private Boolean userSex;

    /**
     * 所在城市
     */
    private String userCity;

    /**
     * 所在省份
     */
    private String userProvince;

    /**
     * 所在国家
     */
    private String userCountry;

    /**
     * 头像url
     */
    private String userAvatarurl;

    /**
     * 微信openid
     */
    private String userWxOpenid;

    private static final long serialVersionUID = 1L;
}