package com.clife.dataplatform.upms.service;

import com.clife.dataplatform.upms.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectAllByUserId(Integer userId);
}
