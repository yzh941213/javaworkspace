package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.query.DeviceMakerQuery;
import com.aishidai.app.model.query.MakerQuery;


@Service
public interface MakerService {

	 List<MakerDO> queryMakerDOList(MakerQuery query)throws Exception;

	 MakerDO queryMakerDOById(long makerId)throws Exception;

	 boolean editMakerDO(MakerDO makerDO)throws Exception;

	 List<MakerDO> queryMakerDOByDistributorId(long distributorId)throws Exception;

	 List<MakerDO> queryMakerDOBySysUserId(long sysUserId)throws Exception;

	 List<MakerDO> queryMakerDOAll( )throws Exception;
	
	 List<MakerDO> queryMakerDOByNameLike(String name) throws Exception;

	/* boolean addDeviceMaker(List<DeviceMakerDO> list,long sysUserId,long makerId)  throws Exception;*/

	 List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker) throws Exception;
}
