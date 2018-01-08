package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.query.CraftsmenQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface CraftsmenDAO {

	public List<CraftsmenDO> queryCraftsmenDOList(CraftsmenQuery query) throws Exception;

	public CraftsmenDO queryCraftsmenDOById(long craftsmenId) throws Exception;

	public CraftsmenDO queryCraftsmenDOBySysUserId(long sysUserId) throws Exception;

	public long editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception;

	public int updateCraftsmenDOStatus(CraftsmenDO craftsmenDO) throws Exception;

	public List<CraftsmenDO> queryCraftsmenDOByDistributorId(long distributorId) throws Exception;

	public List<CraftsmenDO> queryCraftsmenDOByShopId(long shopId) throws Exception;

	public long updateCraftsmenDOSysUserId(CraftsmenDO craftsmenDO);

	public Long queryCraftsmenCount();

	public Long queryCraftsmenCountByDistributor(Long id);

	public Long queryCraftsmenCountByShop(Long shopsId);

	public Long queryCraftsmenCountByMaker(Long id);

	public int updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO);

	public int updateCraftsmanDOAmount(CraftsmenDO craftsmenDO);

	public int updateCraftsmanDOBalance(CraftsmenDO craftsmenDO);
    //审核
	public int updateCraftsmenAudit(CraftsmenDO craftsmenDO) throws Exception;
}
