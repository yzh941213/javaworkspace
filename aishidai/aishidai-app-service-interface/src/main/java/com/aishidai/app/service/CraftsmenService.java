package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.query.CraftsmenQuery;


@Service
public interface CraftsmenService {

	 List<CraftsmenDO> queryCraftsmenDOList(CraftsmenQuery query) throws Exception;

	 CraftsmenDO queryByPrimaryKey(long craftsmenId) throws Exception;

	 Long editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception;

	 Integer updateCraftsmenStatus(CraftsmenDO craftsmenDO) throws Exception;

	 Long addCraftsmenSysUser(CraftsmenDO craftsmenDO) throws Exception;

	 List<CraftsmenDO> queryCraftsmenDOByDistributorId(long distributorId) throws Exception;

	 List<CraftsmenDO> queryCraftsmenDOByShopId(long shopId) throws Exception;

	 List<CraftsmenDO> queryCraftsmenDOBySysUserId(Long sysUserId) throws Exception;

	 Integer updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO) throws Exception;
	 
	 Integer updateCraftsmenAudit(CraftsmenDO craftsmenDO) throws Exception;

	 List<CraftsmenDO> queryCraftsmenExist(String craftsmanName, String telephone) throws Exception;

	 Long insertCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception;

}
