package com.clife.dataplatform.upms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.clife.dataplatform.upms.dao.RoleDao;
import com.clife.dataplatform.upms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> selectAllByUserId(Integer userId){
        return roleDao.selectAllByUserId(userId);
    }
}
