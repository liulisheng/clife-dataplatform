package com.clife.dataplatform.upms.service;

import com.clife.dataplatform.upms.model.User;

public interface UserService {
    User selectByUserName(String userName);
}
