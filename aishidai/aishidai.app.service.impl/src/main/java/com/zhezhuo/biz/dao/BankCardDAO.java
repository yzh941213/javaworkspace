package com.zhezhuo.biz.dao;


import java.util.List;

import com.zhezhuo.model.entity.BankCardDO;
import com.zhezhuo.model.query.BankCardQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface BankCardDAO {

    public List<BankCardDO> queryBankCardDOList(BankCardQuery query) throws Exception;

    public BankCardDO queryBankCardDOById(long bankCardId) throws Exception;

    public long editBankCardDO(BankCardDO bankCardDO) throws Exception;

	public int updateBankCardDOStatus(BankCardDO bankCardDO) throws Exception;

    public List<BankCardDO> queryBankCardDOByUserId(BankCardQuery query) throws Exception;


}
