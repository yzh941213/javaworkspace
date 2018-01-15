package com.aishidai.app.util;

import com.aishidai.app.common.LoginConstant;
import com.aishidai.app.model.pojo.SysUsersDO;

import javax.servlet.http.HttpSession;

public class UserSessionUtil {

    public static SysUsersDO getUser(HttpSession httpSession){
        SysUsersDO sysUsersDO=(SysUsersDO)httpSession.getAttribute(LoginConstant.USER_SESSION_KEY);
        return sysUsersDO;
    }
}
