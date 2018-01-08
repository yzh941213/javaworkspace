package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.query.CraftsmenQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface CraftsmenManager {

	public Result<List<CraftsmenDO>> queryCraftsmenDOList(CraftsmenQuery query);

	public Result<CraftsmenDO> queryCraftsmenDOById(long craftsmenId);

	public Result<Long> editCraftsmenDO(CraftsmenDO craftsmenDO);

	public Result<Integer> updateCraftsmenStatus(CraftsmenDO craftsmenDO);

	public Result<Long> updateCraftsmenSysUserId(CraftsmenDO craftsmenDO);

	public Result<List<CraftsmenDO>> queryCraftsmenDOByDistributorId(long distributorId);

	public Result<List<CraftsmenDO>> queryCraftsmenDOByShopId(long shopId);

	public Result<CraftsmenDO> queryCraftsmenDOBySysUserId(Long sysUserId);

	public Result<Integer> updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO);
	//审核
	public Result<Integer> updateCraftsmenAudit(CraftsmenDO craftsmenDO);

}
