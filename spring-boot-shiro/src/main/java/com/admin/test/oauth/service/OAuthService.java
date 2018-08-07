package com.admin.test.oauth.service;

public interface OAuthService {
    void addAuthCode(String authCode,String username);
    void addAccessToken(String token,String username);
    boolean checkAuthCode(String authCode); // 验证auth code是否有效
    boolean checkAccessToken(String accessToken); // 验证access token是否有效
    String getUsernameByAuthCode(String authCode);// 根据auth code获取用户名
    String getUsernameByAccessToken(String accessToken);// 根据access token获取用户名
    long getExpireIn();//auth code / access token 过期时间
    boolean checkClientId(String clientId);// 检查客户端id是否存在
    boolean checkClientSecret(String clientSecret);// 坚持客户端安全KEY是否存在
}
