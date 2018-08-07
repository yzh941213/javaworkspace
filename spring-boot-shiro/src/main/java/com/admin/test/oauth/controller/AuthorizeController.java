package com.admin.test.oauth.controller;

import com.admin.test.oauth.service.OAuthService;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {

    @Autowired
    private OAuthService authService;

    public void authorize(HttpServletRequest request)
    throws Exception{

        OAuthAuthzRequest authRequest = new OAuthAuthzRequest(request);
        //检查传入的客户端id是否正确
        if (!authService.checkClientId(authRequest.getClientId())){

        }

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){//如果用户没有登录
            if (!login(subject,request)){//尝试重新登录
                //登录失败业务逻辑
            }
        }

        String username = (String) subject.getPrincipal();
        //生成授权码
        String authorizationCode = null;
        //responseType目前仅支持code,另外还有TOKEN
        String responseType = authRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
        if (responseType.equals(ResponseType.CODE.toString())){
            OAuthIssuerImpl authIssuer = new OAuthIssuerImpl(new MD5Generator());
            authorizationCode = authIssuer.authorizationCode();
            authService.addAuthCode(authorizationCode,username);
        }

        //进行oauth响应构建
        OAuthASResponse.OAuthAuthorizationResponseBuilder builder =
                OAuthASResponse.authorizationResponse(request,HttpServletResponse.SC_FOUND);
        //设置授权码
        builder.setCode(authorizationCode);
        //得到客户端重定向地址
        String redirectURI = authRequest.getRedirectURI(); //.getParam(OAuth.OAUTH_REDIRECT_URI);

    }


    private boolean login(Subject subject,HttpServletRequest request){
        if ("get".equalsIgnoreCase(request.getMethod())){
            return false;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return true;
        }catch (Exception ex){
            return false;
        }

    }
}
