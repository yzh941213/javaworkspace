package com.zhezhuo.biz.dao;


import java.util.List;

import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.DistributorQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface DistributorDAO {

    public List<DistributorDO> queryDistributorDOList(DistributorQuery query) throws Exception;

    public DistributorDO queryDistributorDOById(long distributorId) throws Exception;

    public long editDistributorDO(DistributorDO distributorDO) throws Exception;

    public int updateDistributorDOStatus(DistributorDO distributorDO) throws Exception;

    public long updateDistributorDOSysUserId(DistributorDO distributorDO) throws Exception;

	public DistributorDO queryDistributorDOBySysUserId(long sysUserId) throws Exception;

	public Long queryDistributorCount() throws Exception;

	public List<DistributorDO> queryDistributorDOAll(DistributorQuery query) throws Exception;

	public DistributorDO queryDistributorDOByDeviceNo(String deviceNo) throws Exception;

	public int updateDistributorDOAmount(DistributorDO distributorDO) throws Exception;

	public int updateDistributorDOBalance(DistributorDO distributorDO);

	/**
	 * 根据名称模糊查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<DistributorDO> selectDistributorDOByNameLike(String name) throws Exception;
}
