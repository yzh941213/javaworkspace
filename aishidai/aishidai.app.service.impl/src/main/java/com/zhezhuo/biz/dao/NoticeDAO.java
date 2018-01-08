package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.NoticeDO;
import com.zhezhuo.model.query.NoticeQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public interface NoticeDAO {

    List<NoticeDO> queryNoticeDOList(NoticeQuery query);

    NoticeDO queryNoticeDOById(long noId);

    Long delNoticeDOById(long noId);

    Long addNoticeDO(NoticeDO noticeDO);

    Integer queryNoticeDOListCount(NoticeQuery query);
}
