package com.clife.dataplatform.upms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.clife.dataplatform.upms.dao.UserDao;
import com.clife.dataplatform.upms.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }
}
