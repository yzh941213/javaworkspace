package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.AdviseDO;
import com.zhezhuo.model.query.AdviseQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public interface AdviseDAO {

    List<AdviseDO> queryAdviseList(AdviseQuery query);

    Integer queryAdviseListCount(AdviseQuery query);
}
