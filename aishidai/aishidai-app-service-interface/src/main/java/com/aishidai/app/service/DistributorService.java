package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.query.DistributorQuery;


@Service
public interface DistributorService {

	List<DistributorDO> queryDistributorDOList(DistributorQuery query) throws Exception;

	DistributorDO queryDistributorDOById(long distributorId) throws Exception;

	List<DistributorDO> selectDistributorDOByUserId(long sysUserId) throws Exception;
	
	Long editDistributorDO(DistributorDO distributorDO) throws Exception;

	Integer updateDistributorStatus(DistributorDO distributorDO) throws Exception;
	
	Long updateDistributorSysUserId(DistributorDO distributorDO) throws Exception;

	List<DistributorDO> queryDistributorDOAll() throws Exception;

	DistributorDO queryDistributorDOByDeviceNo(String deviceNo) throws Exception;

	List<DistributorDO> queryDistributorDOByNameLike(String name)throws Exception;

	Long insertDistributorDO(DistributorDO distributorDO) throws Exception;
}
