package com.clife.dataplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.clife.dataplatform.commons.ResponseResult;
import com.clife.dataplatform.model.User;
import com.clife.dataplatform.service.UserService;
import com.clife.dataplatform.utils.HttpClient4;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController extends BaseController{

    @Resource
    private UserService userService;
    @RequestMapping("/wxLogin")
    public Object wxLogin(){
        Map<String,String> codeMap=this.getJSONParam(Map.class);
        String code=codeMap.get("code");

        if(code==null){
            return ResponseResult.fail("fail");
        }
        JSONObject SessionKeyOpenId = getSessionKeyOrOpenId( code );
        String openid = SessionKeyOpenId.getString("openid" );
        User user= userService.getUserByOpenid(openid);
        if(user==null){
            user=new User();
            user.setUserAvatarurl("");
            user.setUserName("");
            user.setUserSex(false);
            user.setUserCity("");
            user.setUserProvince("");
            user.setUserCountry("");
            user.setUserAvatarurl("");
            user.setUserWxOpenid(openid);
            userService.insert(user);
        }

        return ResponseResult.success("sucess");
    }



    @RequestMapping("/updateUserInfo")
    public Object updateUserInfo(){
        Map<String,String> codeMap=this.getJSONParam(Map.class);
        String code=codeMap.get("code");
        String signature=codeMap.get("signature");
        String encryptedData=codeMap.get("encryptedData");
        String iv=codeMap.get("iv");
        if(code==null || encryptedData==null || signature==null || iv ==null){
            return ResponseResult.fail("fail");
        }
        JSONObject SessionKeyOpenId = getSessionKeyOrOpenId( code );
        String openid = SessionKeyOpenId.getString("openid" );
        String sessionKey = SessionKeyOpenId.getString( "session_key" );
        JSONObject  jsonObject= WxUtils.getUserInfo(encryptedData,sessionKey, iv);
        User user= userService.getUserByOpenid(openid);

        if(user==null){
            user=new User();
            user.setUserAvatarurl("");
            user.setUserName("");
            user.setUserSex(false);
            user.setUserCity("");
            user.setUserProvince("");
            user.setUserCountry("");
            user.setUserAvatarurl("");
            user.setUserWxOpenid(openid);
            userService.insert(user);
        }else{
            user.setUserName(jsonObject.getString("nickName"));
            user.setUserSex(jsonObject.getBoolean("gender"));
            user.setUserCity(jsonObject.getString("city"));
            user.setUserProvince(jsonObject.getString("province"));
            user.setUserCountry(jsonObject.getString("country"));
            user.setUserAvatarurl(jsonObject.getString("avatarUrl"));
            user.setUserWxOpenid(openid);
            userService.update(user);
        }

        return ResponseResult.success("sucess");
    }



    public static JSONObject getSessionKeyOrOpenId(String code){
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,Object> requestUrlParam = new HashMap<String, Object>( );
        requestUrlParam.put( "appid","wx0b312cd7ce9fd4c8" );//小程序appId
        requestUrlParam.put( "secret","d4a53e2911b52e36f8bd5dc5e160f5e6" );
        requestUrlParam.put( "js_code",wxCode );//小程序端返回的code
        requestUrlParam.put( "grant_type","authorization_code" );//默认参数

        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpClient4.doPost(requestUrl,requestUrlParam));
        return jsonObject;
    }


}
