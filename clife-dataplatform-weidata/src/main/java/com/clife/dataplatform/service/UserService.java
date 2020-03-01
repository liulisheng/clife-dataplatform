package com.clife.dataplatform.service;

import com.clife.dataplatform.model.User;

public interface UserService {

    int insert(User user);

    User getUserByOpenid(String openid);

    int update(User user);
}
