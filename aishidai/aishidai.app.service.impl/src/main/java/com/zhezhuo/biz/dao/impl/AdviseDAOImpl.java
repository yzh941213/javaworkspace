package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.AdviseDAO;
import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.model.entity.AdviseDO;
import com.zhezhuo.model.query.AdviseQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public class AdviseDAOImpl extends BaseDAO implements AdviseDAO {

    public List<AdviseDO> queryAdviseList(AdviseQuery query) {
       // List<AdviseDO> list = super.getSqlMapClientTemplate().queryForList("advise.queryAdviseDOList", query);
        return null;
    }


    public Integer queryAdviseListCount(AdviseQuery query) {
       // Integer count = (Integer) super.getSqlMapClientTemplate().queryForObject("advise.queryAdviseDOListCount", query);
        return null;
    }
}
