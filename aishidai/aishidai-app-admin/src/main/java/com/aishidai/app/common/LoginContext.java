package com.aishidai.app.common;

public class LoginContext {
	
	
	
    /** 是否已登录*/
    private boolean isLogin;
    /** 当前登录的用户数字ID*/
    private Long userId;
    /** 当前登录的用户昵称*/
    private String userNick;
    /**用户类型 1 B商家 2 C商家 */
    private Integer userType=1;
    /**合作伙伴状态合作伙伴状态  0 无效 1信息录入中 2待审核 3冻结 4审核通过 5审核不通过 6作废 （已退出）*/
    private Integer status;



    /**
     * 用户输入数字ID
     */
    private Long inputUserId;
    /**
     * 用户输入的数字Nick
     */
    private String inputNick;


    public Long getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(Long inputUserId) {
        this.inputUserId = inputUserId;
    }

    public String getInputNick() {
        return inputNick;
    }

    public void setInputNick(String inputNick) {
        this.inputNick = inputNick;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserType() {
        return userType;
    }

    /**
     *
     * @param userType 1 B 2 C
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
