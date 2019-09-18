package com.clife.dataplatform.upms.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clife.dataplatform.upms.model.Permission;
import com.clife.dataplatform.upms.model.Role;
import com.clife.dataplatform.upms.model.User;
import com.clife.dataplatform.upms.service.PermissionService;
import com.clife.dataplatform.upms.service.RoleService;
import com.clife.dataplatform.upms.service.UserService;
import com.clife.dataplatform.upms.utils.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;


public class MyShiroRealm extends AuthorizingRealm {

    @Reference
    private UserService userService;

    @Reference
    private PermissionService permissionService;
    @Reference
    private RoleService roleService;
    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
       User user= (User) principalCollection.getPrimaryPrincipal();

        /**
         * 获取角色
         */
        List<Role> roles=roleService.selectAllByUserId(user.getUserId());
        for(Role role:roles){
            authorizationInfo.addRole(role.getRoleCode());
        }
        /**
         * 获取权限
         */
        List<Permission> permissions=permissionService.selectByUserId(user.getUserId());
        for(Permission permission:permissions){
            authorizationInfo.addStringPermission(permission.getPermission());
        }

        return authorizationInfo;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();

        User user=userService.selectByUserName(username);
        if(user==null){
            throw new AuthenticationException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getUserPassword(),                    //密码
                ByteSource.Util.bytes(user.getUserSalt()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(username,true);
        return authenticationInfo;
    }
}
