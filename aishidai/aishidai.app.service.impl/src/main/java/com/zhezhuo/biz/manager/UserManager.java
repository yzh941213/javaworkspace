package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.UserDO;


/**
 * Created by Shaka on 15/4/5.
 */
public interface UserManager {

    /**
     * 登录用户，如果用户名和密码正确，则返回相应的用户信息。
     *
     * @param userId   用户名
     * @param password 密码
     * @return 用户信息，如果用户名或密码不正确，则返回<code>null</code>
     */
    public UserDO login(String userId, String password);

    /**
     *
     * @param userId
     * @return
     */
    public Result<UserDO> queryUserInfo(long userId);

    /**
     *
     * @param userDO
     * @return
     */
    public Result<UserDO> queryUserInfo(UserDO userDO);

//    /**
//     *
//     * @param userDO
//     * @return
//     */
//    public Result<Long> insertUserInfo(UserDO userDO);

    /**
     *
     * @param userDO
     * @return
     */
    public Result<UserDO> insertAndGetUserInfo(UserDO userDO);

//    /**
//     *
//     * @param userDO
//     * @return
//     */
//    public Result updateUserInfo(UserDO userDO);

    /**
     *
     * @param userId
     * @return
     */
    public Result deleteUserInfo(long userId);


    public Result editUserInfo(UserDO userDO);

    Result resetPassword(UserDO userDO);
}
