package com.zhezhuo.biz.dao;

import com.zhezhuo.model.UploadDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/12.
 */
public interface UploadDAO {

    public UploadDO createNewUploadDO(UploadDO uploadDO);

    public UploadDO queryUploadDOById(long id);

    public int updateUploadDOStatus(long id, int status);

    public List<UploadDO> queryUploadDOByUserId(long userId, int type);

    int saveUploadEditResult(UploadDO uploadDO);
}
