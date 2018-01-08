package com.zhezhuo.web.home.common.context;


public class LoginContextHolder {
    private final static ThreadLocal<LoginContext> holder = new ThreadLocal<LoginContext>();

    /**
     * 取得loginContext
     * @return LoginContext
     */
    public static LoginContext getLoginContext() {
        LoginContext loginContext = holder.get();
        if (loginContext == null) {
            loginContext = new LoginContext();
            holder.set(loginContext);
        }
        return loginContext;
    }

    /**
     * 清除loginContext
     */
    public static void clearLoginContext() {
        holder.remove();
    }
}
