package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AdviseDO;
import com.zhezhuo.model.query.AdviseQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public interface AdviseManager {

    Result<List<AdviseDO>> queryAdviseList(AdviseQuery query);
}
