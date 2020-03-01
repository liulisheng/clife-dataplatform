package com.clife.dataplatform.controller;

import com.clife.dataplatform.model.ShareInfo;
import com.clife.dataplatform.service.ShareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shareInfo")
public class ShareInfoController extends BaseController{


    @Autowired
   private ShareInfoService shareInfoService;

    @RequestMapping("/add")
    public Object add(){
        ShareInfo shareInfo=this.getJSONParam(ShareInfo.class);
        if (shareInfo==null){
            shareInfo=new ShareInfo();
        }
        return shareInfoService.insert(shareInfo);
    }




}
