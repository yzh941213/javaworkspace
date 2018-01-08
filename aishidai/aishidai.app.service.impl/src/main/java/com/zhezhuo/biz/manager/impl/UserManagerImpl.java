package com.zhezhuo.biz.manager.impl;

import com.qiniu.util.StringUtils;
import com.zhezhuo.biz.dao.UserDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.UserManager;
import com.zhezhuo.biz.util.PasswordHash;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by Shaka on 15/4/5.
 */
public class UserManagerImpl implements UserManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserDAO userDAO;
    @Resource
    CacheManager cacheManager;

    @Override
    public UserDO login(String userName, String password) {
        UserDO userDO = (UserDO) cacheManager.get(String.valueOf(userName));

        if (userDO != null) {
            return userDO;
        }

        Result<UserDO> result = userDAO.queryUserInfo(userName, password);
        if (result.isSuccess() && result.getResult() != null) {
            cacheManager.put(userName, result.getResult());
        }

        return result.getResult();
    }

    public Result<UserDO> queryUserInfo(long userId) {
        Result<UserDO> result = new Result<UserDO>();

        UserDO userDO = (UserDO) cacheManager.get(String.valueOf(userId));

        if (userDO != null) {
            result.setResult(userDO);
            result.setSuccess(true);
            return result;
        }

        result = userDAO.queryUserInfo(userId);
        if (result.isSuccess() && result.getResult() != null) {
            cacheManager.put(String.valueOf(userId), result.getResult());
        }

        return result;
    }

    public Result<UserDO> queryUserInfo(UserDO userDO) {
        return userDAO.queryUserInfo(userDO);
    }

    public Result<Long> insertUserInfo(UserDO userDO) {
        userDO.setPassword(PasswordHash.createHash(userDO.getPassword()));
        return userDAO.insertUserInfo(userDO);
    }

    public Result<UserDO> insertAndGetUserInfo(UserDO userDO) {
        userDO.setPassword(PasswordHash.createHash(userDO.getPassword()));
        return userDAO.insertAndGetUserInfo(userDO);
    }

    public Result updateUserInfo(UserDO userDO) {
        userDO.setPassword(PasswordHash.createHash(userDO.getPassword()));
        return userDAO.updateUserInfo(userDO);
    }

    public Result deleteUserInfo(long userId) {
        return userDAO.deleteUserInfo(userId);
    }

    public Result editUserInfo(UserDO userDO) {
        Result result = null;

        UserDO query = login(userDO.getName(), userDO.getPassword());

        if (query != null && query.getId() > 0) {
            userDO.setId(query.getId());

            if (!StringUtils.isNullOrEmpty(userDO.getNewpasswd())) {
                userDO.setPassword(userDO.getNewpasswd());
            }
            result = userDAO.updateUserInfo(userDO);
            cacheManager.put(String.valueOf(userDO.getId()), userDO);
        } else {
            result = userDAO.insertUserInfo(userDO);
            if (result.isSuccess()) {
                cacheManager.put(String.valueOf(userDO.getId()), userDO);
            }
        }

        return result;
    }

    @Override
    public Result resetPassword(UserDO userDO) {
        Result result = null;

        UserDO query = login(userDO.getName(), userDO.getPassword());

        if (query != null && query.getId() > 0) {
            userDO.setId(query.getId());

            if (!StringUtils.isNullOrEmpty(userDO.getNewpasswd())) {
                query.setPassword(userDO.getNewpasswd());
            }
            result = userDAO.resetPassword(query);
            cacheManager.put(String.valueOf(query.getId()), query);
        }
        return result;
    }
}
