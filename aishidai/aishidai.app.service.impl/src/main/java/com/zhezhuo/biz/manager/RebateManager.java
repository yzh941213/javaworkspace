package com.zhezhuo.biz.manager;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RebateDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface RebateManager {

    Result<Long> createRebateDO(RebateDO rebateDO);

    Result<List<RebateDO>> queryRebates();

    Result<Integer> updateRebate(RebateDO rebateDO);
}
