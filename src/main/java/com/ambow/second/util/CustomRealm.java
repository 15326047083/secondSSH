package com.ambow.second.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ambow.second.entity.User;
import com.ambow.second.service.IUserPermissionsService;
import com.ambow.second.service.IUserRolesService;
import com.ambow.second.service.impl.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private IUserRolesService userRolesService;

    @Autowired
    private IUserPermissionsService userPermissionsService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        // TODO Auto-generated method stub
        String userName = (String) arg0.getPrimaryPrincipal();
        Set<String> roles = getRolesByEmail(userName);
        Set<String> permissions = getPermissionsByRoles(roles);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        authorizationInfo.setRoles(roles);

        return authorizationInfo;
    }

    private Set<String> getPermissionsByRoles(Set<String> roles) {
        List<String> list = new ArrayList<String>();
        for (String str : roles) {
            List<String> userPermissionsList = userPermissionsService.getByRoles(str);
            list.addAll(userPermissionsList);
        }
        Set<String> set = new HashSet<>(list);
        return set;
    }

    @SuppressWarnings("unchecked")
    private Set<String> getRolesByEmail(String userName) {
        // TODO Auto-generated method stub
        List<String> list = userRolesService.getRolesByNum(userName);
        Set<String> set = new HashSet<>(list);
        return set;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {

        // TODO Auto-generated method stub
        // 从页面获取用户名;
        String userNum = (String) arg0.getPrincipal();
        // 通过用户名获取凭证；
        String password = getPasswordByUserName(Integer.parseInt(userNum));
        if (password == null)
            return null;
        User user = new User();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userNum, password, "customRealm");
        return authenticationInfo;
    }

    private String getPasswordByUserName(int userNum) {
        // TODO Auto-generated method stub
        System.out.println(userNum);
        System.out.println(userService.getByNum(userNum).toString());
        return userService.getByNum(userNum).getPassword();
    }
}