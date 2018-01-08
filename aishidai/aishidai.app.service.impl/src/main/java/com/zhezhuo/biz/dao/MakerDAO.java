package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.DeviceMakerDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.query.DeviceMakerQuery;
import com.zhezhuo.model.query.MakerQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface MakerDAO {

	public List<MakerDO> queryMakerDOList(MakerQuery query) throws Exception;

	public MakerDO queryMakerDOById(long shopId) throws Exception;

	public MakerDO queryMakerDOBySysUserId(long sysUserId) throws Exception;

	public long editMakerDO(MakerDO makerDO) throws Exception;

	public int updateMakerDOStatus(MakerDO makerDO) throws Exception;

	public List<MakerDO> queryMakerDOByDistributorId(long distributorId) throws Exception;

	public Long updateMakerDOSysUserId(MakerDO makerDO) throws Exception;

	public Long queryMakerCount() throws Exception;

	public Long queryMakerCountByDistributor(Long id) throws Exception;

	public List<MakerDO> queryMakerDOAll(MakerQuery query) throws Exception;

	public int updateMakerDOAmount(MakerDO makerDO) throws Exception;

	public int updateMakerDOBalance(MakerDO makerDO);
	//审核
	public int updateMakerDOAudit(MakerDO makerDO) throws Exception;

	List<MakerDO> selectMakerDOByNameLike(MakerDO makerDO) throws Exception;

	public long insetDeviceMaker(DeviceMakerDO deviceMakerDO) throws Exception;
	
	public List<DeviceMakerDO> selectDeviceMaker(DeviceMakerQuery query) throws Exception; 
	
	public int delDeviceMaker(DeviceMakerDO deviceMakerDO) throws Exception;
	
}
