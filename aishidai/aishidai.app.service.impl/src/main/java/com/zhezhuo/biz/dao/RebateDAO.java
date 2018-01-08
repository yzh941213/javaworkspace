package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.RebateDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface RebateDAO {

    Long createRebateDO (RebateDO rebateDO);

    List<RebateDO> queryRebates();

    Integer updateRebate(RebateDO rebateDO);


}
