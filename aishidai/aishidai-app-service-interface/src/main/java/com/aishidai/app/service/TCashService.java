package com.aishidai.app.service;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.TCashDTO;
import com.zhezhuo.model.entity.TCashDO;
import com.zhezhuo.model.query.TCashQuery;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public interface TCashService {

	Result<Integer> updateTCashStatus(TCashDO tCashDO);

	Result<List<TCashDTO>> queryTCashList(TCashQuery query);

	Result<TCashDO> queryTcashDOById(long caId);

	Result<Long> editTCashDO(TCashDO tCashDO);

}
