package com.aishidai.app.common;

/**
 *
 */
public interface LoginConstant {
	
    /** 在session中保存petstore用户对象的key。 */
    //String USER_SESSION_KEY = "userSessionKey";

    /** Login页面返回URL的key。 */
    String LOGIN_RETURN_KEY = "return";

    /** 如果未指定return，登录以后就跳到该URL。 */
    String LOGIN_RETURN_DEFAULT_LINK = "homeLink";

    /** 登录URL的名字。 */
    String LOGIN_LINK = "loginLink";

    /** 登记用户URL的名字。 */
    String REGISTER_LINK = "registerLink";

    /** 登记用户信息URL的名字。 */
    String REGISTER_ACCOUNT_LINK = "registerAccountLink";

    String USER_LOGIN_LINK = "";
    
    static final String USER_SESSION_KEY = "user_session_key";
    static final String USER_DISTRIBUTOR_SESSION_KEY = "user_distributor_session_key";
    static final String USER_SHOP_SESSION_KEY = "user_shop_session_key";
    static final String USER_MAKER_SESSION_KEY = "user_maker_session_key";
    static final String USER_CRAFTSMEN_SESSION_KEY = "user_craftsmen_session_key";
    
}
