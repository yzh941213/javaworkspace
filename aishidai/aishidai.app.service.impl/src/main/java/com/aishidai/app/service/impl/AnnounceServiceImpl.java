package com.aishidai.app.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.zhezhuo.biz.dao.AnnounceDAO;
import com.zhezhuo.biz.manager.AnnounceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AnnounceDO;
import com.zhezhuo.model.query.AnnounceQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/21.
 */
public class AnnounceServiceImpl implements AnnounceManager {

    @Autowired
    AnnounceDAO announceDAO;

    private Logger logger = LoggerFactory.getLogger(AnnounceServiceImpl.class);

    
    public Result<List<AnnounceDO>> queryAnnounceList(AnnounceQuery query) {
        Result<List<AnnounceDO>> result = new Result<List<AnnounceDO>>();
        try {
            List<AnnounceDO> list = announceDAO.queryAnnounceList(query);
            result.setSuccess(true);
            result.setResult(list);
            return result;
        } catch (Exception e) {
            logger.info(e.getMessage());
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }

    
    public Result<AnnounceDO> queryAnnounceInfo(int annoId) {
        Result<AnnounceDO> result = new Result<AnnounceDO>();
        try {
            AnnounceDO announceDO = announceDAO.queryAnnounceDOById(annoId);
            result.setResult(announceDO);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.info(e.getMessage());
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }

    
    public Result<Long> editAnnounceDO(AnnounceDO announceDO) {
        Result<Long> result = new Result<Long>();
        try {
            long row = 0;
            if (announceDO.getAnId() <= 0) {
                // TODO: 2016/9/21 insert
                row = announceDAO.addAnnounceDO(announceDO);
            } else {
                // TODO: 2016/9/21 update
                row = announceDAO.updateAnnounceDO(announceDO);

            }
            if (row > 0) {
                result.setSuccess(true);
                result.setResult(announceDO.getAnId());
                return result;
            }
            result.setSuccess(false);
            result.setResult(row);
            return result;
        } catch (Exception e) {
            result.setSuccess(false);
            result.setResult(Long.valueOf(-1));
            return result;
        }
    }

    
    public Result<Integer> deleteAnnounceDO(int annoId) {
        Result<Integer> result = new Result<Integer>();
        try {
            int row = announceDAO.deleteAnnounce(annoId);
            result.setResult(row);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.info(e.getMessage());
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }
}
