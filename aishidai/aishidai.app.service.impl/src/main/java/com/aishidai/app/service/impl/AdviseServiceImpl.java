package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.AdviseDAO;
import com.zhezhuo.biz.manager.AdviseManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AdviseDO;
import com.zhezhuo.model.query.AdviseQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public class AdviseServiceImpl implements AdviseManager {

    @Autowired
    AdviseDAO adviseDAO;

    Logger logger = LoggerFactory.getLogger(AdviseServiceImpl.class);

    
    public Result<List<AdviseDO>> queryAdviseList(AdviseQuery query) {
        Result<List<AdviseDO>> result = new Result<List<AdviseDO>>();
        try {
            List<AdviseDO> list = adviseDAO.queryAdviseList(query);
            result.setSuccess(true);
            result.setResult(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("query advises failed");
            result.setSuccess(false);
            return result;
        }
    }
}
