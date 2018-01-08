package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.BankCardDO;
import com.zhezhuo.model.query.BankCardQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface BankCardManager {

    public Result<List<BankCardDO>> queryBankCardDOList(BankCardQuery query);

    public Result<BankCardDO> queryBankCardDOById(long attributeId);

    public Result<Long> editBankCardDO(BankCardDO bankCardDO);

    public Result<Integer> updateBankCardStatus(BankCardDO bankCardDO);

    public Result<List<BankCardDO>> queryBankCardDOByUserId(BankCardQuery query);

}
