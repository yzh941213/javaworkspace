package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.domain.TCashDTO;
import com.zhezhuo.model.entity.TCashDO;
import com.zhezhuo.model.query.TCashQuery;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public interface TCashDAO {

    Integer updateTCashDOStatus(TCashDO tCashDO);

    Integer queryTCashListCount(TCashQuery query);

    List<TCashDTO> queryTCashList(TCashQuery query);

    TCashDO queryTCashById(long caId);

	long editTCashDO(TCashDO tCashDO);
}
