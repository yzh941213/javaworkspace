package com.zhezhuo.web.home.common.context;

import com.zhezhuo.model.entity.SysUsersDO;

public class SysUserThreadLocal {

	private static final ThreadLocal<SysUsersDO> userHolder = new ThreadLocal<SysUsersDO>();
	
	public static final SysUsersDO getCurrentUser() {
        return userHolder.get();
    }

    public static final void setCurrentUser(SysUsersDO sysUser) {
        userHolder.set(sysUser);
    }

}
