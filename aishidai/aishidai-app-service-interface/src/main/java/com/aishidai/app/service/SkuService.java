package com.aishidai.app.service;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.SkuDetailDTO;
import com.zhezhuo.model.entity.SkuDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface SkuService {

    public Result<List<SkuDetailDTO>> querySkuDOList(long itemId);

    public Result<Integer> updateSkuDOStatus(SkuDO skuDO);

    public Result<Integer> editSkuDO(List<SkuDO> skuDOs, long ItemId) throws Exception;

}
