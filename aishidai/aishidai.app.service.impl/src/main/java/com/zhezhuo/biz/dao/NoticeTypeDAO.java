package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.NoticeTypeDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public interface NoticeTypeDAO {

    List<NoticeTypeDO> queryNoticeDOList();

    String queryNoticeTypeName(long noticeTypeId);

}
