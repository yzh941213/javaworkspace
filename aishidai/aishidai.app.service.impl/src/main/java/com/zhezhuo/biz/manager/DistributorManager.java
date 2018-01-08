package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.DistributorQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface DistributorManager {

	public Result<List<DistributorDO>> queryDistributorDOList(DistributorQuery query);

	public Result<DistributorDO> queryDistributorDOById(long distributorId);

	public Result<DistributorDO> queryDistributorDOBySysUserId(long sysUserId);
	
	public Result<Long> editDistributorDO(DistributorDO distributorDO);

	public Result<Integer> updateDistributorStatus(DistributorDO distributorDO);
	
	public Result<Long> updateDistributorSysUserId(DistributorDO distributorDO);

	public Result<List<DistributorDO>> queryDistributorDOAll(DistributorQuery query);

	public Result<DistributorDO> queryDistributorDOByDeviceNo(String deviceNo);

	/**
	 * 根据经销商名称模糊查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<DistributorDO> queryDistributorDOByNameLike(String name)throws Exception;
}
