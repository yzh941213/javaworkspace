package com.aishidai.app.service;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.NoticeDO;
import com.zhezhuo.model.entity.NoticeTypeDO;
import com.zhezhuo.model.query.NoticeQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public interface NoticeService {

    Result<List<NoticeDO>> queryNoticeList(NoticeQuery query);

    Result<NoticeDO> queryNoticeDOById(long noId);

    Result<Long> delNoticeDOById(long noId);

    Result<Long> addNoticeDO(NoticeDO noticeDO);

    Result<List<NoticeTypeDO>> queryNoticeTypeList();

}
