package com.clife.dataplatform.service.impl;

import com.clife.dataplatform.dao.UserDao;
import com.clife.dataplatform.model.User;
import com.clife.dataplatform.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User getUserByOpenid(String openid) {
        return userDao.getUserByOpenid(openid);
    }

    @Override
    public int update(User user) {
        return userDao.updateByPrimaryKey(user);
    }
}
