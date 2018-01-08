package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.AnnounceDO;
import com.zhezhuo.model.query.AnnounceQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/21.
 */
public interface AnnounceDAO {


    List<AnnounceDO> queryAnnounceList(AnnounceQuery query);

    AnnounceDO queryAnnounceDOById(int annoId);

    Integer updateAnnounceDO(AnnounceDO announceDO);

    Long addAnnounceDO(AnnounceDO announceDO);

    Integer deleteAnnounce(int annoId);
}
