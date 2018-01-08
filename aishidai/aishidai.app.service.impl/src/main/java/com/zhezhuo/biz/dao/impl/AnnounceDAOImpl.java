package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.AnnounceDAO;
import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.model.entity.AnnounceDO;
import com.zhezhuo.model.query.AnnounceQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/21.
 */
public class AnnounceDAOImpl extends BaseDAO implements AnnounceDAO {

    public List<AnnounceDO> queryAnnounceList(AnnounceQuery query) {

        return null;
    }


    public AnnounceDO queryAnnounceDOById(int annoId) {

        return null;
    }


    public Integer updateAnnounceDO(AnnounceDO announceDO) {

        return 1;
    }


    public Long addAnnounceDO(AnnounceDO announceDO) {
       // Long row = (Long) this.getSqlMapClientTemplate().insert("announce.addAnnounceDO", announceDO);
        return 1l;
    }


    public Integer deleteAnnounce(int annoId) {
       // int row = this.getSqlMapClientTemplate().update("announce.deleteAnnounceDO", annoId);
        return 1;
    }
}
