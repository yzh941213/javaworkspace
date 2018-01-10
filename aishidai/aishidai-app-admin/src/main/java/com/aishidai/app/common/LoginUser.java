package com.aishidai.app.common;



import org.apache.commons.lang.StringUtils;


import java.io.Serializable;

public class LoginUser implements Serializable {
    private static final long serialVersionUID = -7507510429755782596L;
    //使用到了一个本地线程
    private static final ThreadLocal<LoginUser> userHolder = new ThreadLocal<LoginUser>();
    private String userId;
    private String userName;
    private String userNick;

    public static final LoginUser getCurrentUser() {
        return userHolder.get();
    }

    public static final void setCurrentUser(LoginUser user) {
        userHolder.set(user);
    }

 
    
    
    /**
     * 创建匿名用户。
     */
    public LoginUser() {
    }

    public LoginUser(String userId) {
        this.userId = StringUtils.trimToNull(userId);
    }

    public String getId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void upgrade(String userId, String userName, String userNick) {
        userId = StringUtils.trimToNull(userId);
        this.userId = userId;
        this.userName = userName;
        this.userNick = userNick;
    }

    public boolean hasLoggedIn() {
        return userId != null;
    }

}
