package com.zhezhuo.biz.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.UserDAO;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.UserDO;

/**
 * Created by Shaka on 15/4/5.
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    public Result<UserDO> queryUserInfo(long userId) {
        return null;
    }

    public Result<UserDO> queryUserInfo(UserDO userDO) {
        return null;
    }

    public Result<Long> insertUserInfo(UserDO userDO) {
        return null;
    }

    public Result<UserDO> insertAndGetUserInfo(UserDO userDO) {
        return null;
    }

    public Result updateUserInfo(UserDO userDO) {
        return null;
    }

    public Result deleteUserInfo(long userId) {
        return null;
    }

    public Result<UserDO> queryUserInfo(String userId, String password) {
        return null;
    }

    public Result<Long> resetPassword(UserDO query) {
        return null;
    }
}
