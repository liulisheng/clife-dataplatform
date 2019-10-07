package com.clife.dataplatform.service.impl;

import com.clife.dataplatform.dao.ShareInfoDao;
import com.clife.dataplatform.model.ShareInfo;
import com.clife.dataplatform.service.ShareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShareInfoServiceImpl implements ShareInfoService {
   @Autowired
   private ShareInfoDao shareInfoDao;
    @Override
    public int insert(ShareInfo record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setDelFlag(true);
        return shareInfoDao.insert(record);
    }
}
