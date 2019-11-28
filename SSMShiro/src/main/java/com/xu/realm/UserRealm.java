package com.xu.realm;

import com.xu.domain.User;
import com.xu.service.PermissionService;
import com.xu.service.RoleService;
import com.xu.service.UserService;
import com.xu.util.ActiveUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 自定义认证方式
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证方法");

        String username = token.getPrincipal().toString();
        String password = token.getCredentials().toString();
        System.out.println("获取前端参数username + password = " + username + password);

        /**
         * 去数据库查询数据,判断是否用户名和密码是否正确
         */
        User user = userService.queryUserByUserName(username);
        if (user != null) {
            Collection<String> roles = roleService.queryRoleByUserId(user.getUserid());
            Collection<String> permissions = permissionService.queryPermissionByUserId(user.getUserid());
            ActiveUser activeUser = new ActiveUser(user, roles, permissions);
            /**
             * 使用自定义的realm，账号密码在这里进行比较
             *     zhangsan会在这里传到doGetAuthorizationInfo方法
             */
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername() + user.getAddress());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                    activeUser, user.getUserpwd(),
                    credentialsSalt, this.getClass().getSimpleName());
            return info;
        } else {
            return null;
        }
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /**
         * 自定义授权方式
         */
        System.out.println("授权方法");
        //创建授权对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
        if (activeUser.getRoles() != null && activeUser.getRoles().size() > 0) {
            info.addRoles(activeUser.getRoles());
        }
        if (activeUser.getPermissions() != null && activeUser.getPermissions().size() > 0) {
            info.addStringPermissions(activeUser.getPermissions());
        }
        return info;
    }

}
