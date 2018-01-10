package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.query.DistributorQuery;


@Service
public interface DistributorService {

	/*public Result<List<DistributorDO>> queryDistributorDOList(DistributorQuery query);

	public Result<DistributorDO> queryDistributorDOById(long distributorId);*/

	List<DistributorDO> queryDistributorDOBySysUserId(long sysUserId);
	
	/*public Result<Long> editDistributorDO(DistributorDO distributorDO);

	public Result<Integer> updateDistributorStatus(DistributorDO distributorDO);
	
	public Result<Long> updateDistributorSysUserId(DistributorDO distributorDO);

	public Result<List<DistributorDO>> queryDistributorDOAll(DistributorQuery query);

	public Result<DistributorDO> queryDistributorDOByDeviceNo(String deviceNo);

	*//**
	 * 根据经销商名称模糊查询
	 * @param name
	 * @return
	 * @throws Exception
	 *//*
	List<DistributorDO> queryDistributorDOByNameLike(String name)throws Exception;*/
}
