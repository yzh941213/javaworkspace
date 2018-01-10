package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.MakerDO;
import org.springframework.stereotype.Service;


@Service
public interface MakerService {

	/*public Result<List<MakerDO>> queryMakerDOList(MakerQuery query);

	public Result<MakerDO> queryMakerDOById(long makerId);

	public Result<Long> editMakerDO(MakerDO makerDO);

	public Result<Integer> updateMakerStatus(MakerDO makerDO);

	public Result<Long> updateMakerSysUserId(MakerDO makerDO);

	public Result<List<MakerDO>> queryMakerDOByDistributorId(long distributorId);*/

	public List<MakerDO> queryMakerDOBySysUserId(Long sysUserId);

	/*public Result<List<MakerDO>> queryMakerDOAll(MakerQuery query);
	//审核
	public Result<Integer> updateMakerAudit(MakerDO makerDO);

	*//**
	 * 根据创客的名称模糊查询
	 * @param makerDO
	 * @return
	 * @throws Exception
	 *//*
	public List<MakerDO> queryMakerDOByNameLike(MakerDO makerDO) throws Exception;

	public boolean addDeviceMaker(List<DeviceMakerDO> list,long sysUserId,long makerId)  throws Exception;

	public List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker) throws Exception;*/
}
