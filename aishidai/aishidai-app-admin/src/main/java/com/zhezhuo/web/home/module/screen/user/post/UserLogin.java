package com.zhezhuo.web.home.module.screen.user.post;

import com.zhezhuo.web.home.module.screen.BaseScreen;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shaka on 15/6/13.
 */
@Controller
public class UserLogin extends BaseScreen {

    static final String KEY_SESSION = "csession";
    static final String KEY_USER_ID = "uid";
    static final String KEY_USER_NAME = "uname";
    static final String KEY_USER_NICK = "unick";

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // 获取Cookie
        Cookie[] cookies = request.getCookies();

        String userId = "";
        String userName = "";
        String userNick = "";

        for (Cookie cookie : cookies){
            if(KEY_USER_ID.equalsIgnoreCase(cookie.getName())){
                userId = cookie.getValue();
            }
            if(KEY_USER_NAME.equalsIgnoreCase(cookie.getName())){
                userName = cookie.getValue();
            }
            if(KEY_USER_NICK.equalsIgnoreCase(cookie.getName())){
                userNick = cookie.getValue();
            }
        }

        if(StringUtils.isBlank(userName)){

        }

        // 创建Cookie
        Cookie cookie = new Cookie("CookieName", "CookieValue");
        cookie.setMaxAge(10);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

}
