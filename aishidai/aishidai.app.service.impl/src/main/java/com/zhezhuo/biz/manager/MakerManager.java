package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DeviceMakerDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.query.DeviceMakerQuery;
import com.zhezhuo.model.query.MakerQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface MakerManager {

	public Result<List<MakerDO>> queryMakerDOList(MakerQuery query);

	public Result<MakerDO> queryMakerDOById(long makerId);

	public Result<Long> editMakerDO(MakerDO makerDO);

	public Result<Integer> updateMakerStatus(MakerDO makerDO);

	public Result<Long> updateMakerSysUserId(MakerDO makerDO);

	public Result<List<MakerDO>> queryMakerDOByDistributorId(long distributorId);

	public Result<MakerDO> queryMakerDOBySysUserId(Long sysUserId);

	public Result<List<MakerDO>> queryMakerDOAll(MakerQuery query);
	//审核
	public Result<Integer> updateMakerAudit(MakerDO makerDO);

	/**
	 * 根据创客的名称模糊查询
	 * @param makerDO
	 * @return
	 * @throws Exception
	 */
	public List<MakerDO> queryMakerDOByNameLike(MakerDO makerDO) throws Exception;

	public boolean addDeviceMaker(List<DeviceMakerDO> list,long sysUserId,long makerId)  throws Exception;

	public List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker) throws Exception;
}
