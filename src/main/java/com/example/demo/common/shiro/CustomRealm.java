/*
package com.example.demo.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

*/
/**
 * @author jiwei.chen
 * @create 2018-11-22
 * @detail 自定义realm
 *//*

@Component
public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();

        //通过用户名称查询角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    */
/*    Set<String> roles = getRoles(principal);
        Set<String> perms = getPerms(principal);
        info.setRoles(roles);
        info.setStringPermissions(perms);*//*

        return info;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //get
        String principal = (String) authenticationToken.getPrincipal();

        String credentials = new String((char[])authenticationToken.getCredentials());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, "realName");
            //加salt
            //info.setCredentialsSalt(ByteSource.Util.bytes("mark"));
            return info;

    }

}
*/
