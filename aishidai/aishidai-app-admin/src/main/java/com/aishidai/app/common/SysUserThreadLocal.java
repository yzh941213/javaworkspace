package com.aishidai.app.common;

import com.aishidai.app.model.pojo.SysUsersDO;


public class SysUserThreadLocal {

	private static final ThreadLocal<SysUsersDO> userHolder = new ThreadLocal<SysUsersDO>();
	
	public static final SysUsersDO getCurrentUser() {
        return userHolder.get();
    }

    public static final void setCurrentUser(SysUsersDO sysUser) {
        userHolder.set(sysUser);
    }

}
