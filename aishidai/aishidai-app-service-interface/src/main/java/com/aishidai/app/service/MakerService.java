package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOCustom;
import com.aishidai.app.model.query.MakerQuery;


@Service
public interface MakerService {

	 List<MakerDOCustom> queryMakerDOList(MakerQuery query)throws Exception;

	 MakerDOCustom queryMakerDOById(long makerId)throws Exception;

	 boolean editMakerDO(MakerDO makerDO)throws Exception;

	 List<MakerDO> queryMakerDOByDistributorId(long distributorId)throws Exception;

	 List<MakerDO> queryMakerDOBySysUserId(long sysUserId)throws Exception;

	 List<MakerDO> queryMakerDOAll( )throws Exception;
	
	 List<MakerDO> queryMakerDOByNameLike(MakerDO makerDO) throws Exception;

	 boolean addDeviceMaker(List<DeviceMakerDO> list,long userId,long makerId)  throws Exception;

	 long insertMaker(MakerDO MakerDO);

	 boolean editDeviceMaker(List<DeviceMakerDO> list, long userId, long id);

	 long queryMakerDOListCount(MakerQuery makerQuery);
}
