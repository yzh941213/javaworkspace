package com.admin.test.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm {

    @Override
    public String getName() {
        return "realm2";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//用户名
        String password = new String((char[])token.getCredentials());
        if (!"yzh@qq.com".equals(username)){
            throw new UnknownAccountException(); //如果用户名错误
        }
        if (!"123456".equals(password)){
            throw new UnsupportedOperationException();//密码错误
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
