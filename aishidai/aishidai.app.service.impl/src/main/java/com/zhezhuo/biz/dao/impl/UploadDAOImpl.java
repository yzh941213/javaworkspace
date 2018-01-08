package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.UploadDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.model.UploadDO;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shaka on 15/6/12.
 */
public class UploadDAOImpl extends BaseDAO implements UploadDAO {

    public UploadDO createNewUploadDO(UploadDO uploadDO) {
        return null;
    }

    public UploadDO queryUploadDOById(long id) {
        return null;
    }

    public int updateUploadDOStatus(long id, int status) {
        return 0;
    }

    public List<UploadDO> queryUploadDOByUserId(long userId, int type) {
        return null;
    }

    public int saveUploadEditResult(UploadDO uploadDO) {
        return 0;
    }
}
