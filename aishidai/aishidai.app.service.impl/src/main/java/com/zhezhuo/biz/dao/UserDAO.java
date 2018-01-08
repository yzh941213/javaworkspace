package com.zhezhuo.biz.dao;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.UserDO;


/**
 * Created by Shaka on 15/4/5.
 */
public interface UserDAO {
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

    /**
     *
     * @param userDO
     * @return
     */
    public Result<Long> insertUserInfo(UserDO userDO);

    /**
     *
     * @param userDO
     * @return
     */
    public Result<UserDO> insertAndGetUserInfo(UserDO userDO);

    /**
     *
     * @param userDO
     * @return
     */
    public Result updateUserInfo(UserDO userDO);

    /**
     *
     * @param userId
     * @return
     */
    public Result deleteUserInfo(long userId);

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    Result<UserDO> queryUserInfo(String userId, String password);

    /**
     *
     * @param query
     * @return
     */
    Result<Long> resetPassword(UserDO query);
}
