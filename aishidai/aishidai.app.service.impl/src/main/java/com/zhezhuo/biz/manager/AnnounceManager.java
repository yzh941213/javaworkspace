package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AnnounceDO;
import com.zhezhuo.model.query.AnnounceQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/21.
 */
public interface AnnounceManager {

    Result<List<AnnounceDO>> queryAnnounceList(AnnounceQuery query);

    Result<AnnounceDO> queryAnnounceInfo(int annoId);

    Result<Long> editAnnounceDO(AnnounceDO announceDO);

    Result<Integer> deleteAnnounceDO(int annoId);

}
