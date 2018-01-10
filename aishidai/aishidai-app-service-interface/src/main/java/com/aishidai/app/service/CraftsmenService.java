package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.CraftsmenDO;
import org.springframework.stereotype.Service;


@Service
public interface CraftsmenService {

	/*public Result<List<CraftsmenDO>> queryCraftsmenDOList(CraftsmenQuery query);

	public Result<CraftsmenDO> queryCraftsmenDOById(long craftsmenId);

	public Result<Long> editCraftsmenDO(CraftsmenDO craftsmenDO);

	public Result<Integer> updateCraftsmenStatus(CraftsmenDO craftsmenDO);

	public Result<Long> updateCraftsmenSysUserId(CraftsmenDO craftsmenDO);

	public Result<List<CraftsmenDO>> queryCraftsmenDOByDistributorId(long distributorId);

	public Result<List<CraftsmenDO>> queryCraftsmenDOByShopId(long shopId);*/

	public List<CraftsmenDO> queryCraftsmenDOBySysUserId(Long sysUserId);

	/*public Result<Integer> updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO);
	//审核
	public Result<Integer> updateCraftsmenAudit(CraftsmenDO craftsmenDO);*/

}
