package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.query.CraftsmenQuery;


@Service
public interface CraftsmenService {

	 List<CraftsmenDO> queryCraftsmenDOList(CraftsmenQuery query) throws Exception;

	 CraftsmenDO queryByPrimaryKey(long craftsmenId) throws Exception;

	 boolean editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception;

	 long addCraftsmenSysUser(CraftsmenDO craftsmenDO) throws Exception;

	 List<CraftsmenDO> queryCraftsmenDOByDistributorId(long distributorId) throws Exception;

	 List<CraftsmenDO> queryCraftsmenDOByShopId(long shopId) throws Exception;

	 List<CraftsmenDO> queryCraftsmenDOBySysUserId(long sysUserId) throws Exception;


	 List<CraftsmenDO> queryCraftsmenExist(String craftsmanName, String telephone) throws Exception;

	 boolean insertCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception;

}
