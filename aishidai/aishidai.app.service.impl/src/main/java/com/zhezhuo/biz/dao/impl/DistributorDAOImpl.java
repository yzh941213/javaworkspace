package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.DistributorDAO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.DistributorQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class DistributorDAOImpl extends BaseDAO implements DistributorDAO {
	public List<DistributorDO> queryDistributorDOList(DistributorQuery query) throws Exception {
		return null;
	}

	public DistributorDO queryDistributorDOById(long distributorId) throws Exception {
		return null;
	}

	public long editDistributorDO(DistributorDO distributorDO) throws Exception {
		return 0;
	}

	public int updateDistributorDOStatus(DistributorDO distributorDO) throws Exception {
		return 0;
	}

	public long updateDistributorDOSysUserId(DistributorDO distributorDO) throws Exception {
		return 0;
	}

	public DistributorDO queryDistributorDOBySysUserId(long sysUserId) throws Exception {
		return null;
	}

	public Long queryDistributorCount() throws Exception {
		return null;
	}

	public List<DistributorDO> queryDistributorDOAll(DistributorQuery query) throws Exception {
		return null;
	}

	public DistributorDO queryDistributorDOByDeviceNo(String deviceNo) throws Exception {
		return null;
	}

	public int updateDistributorDOAmount(DistributorDO distributorDO) throws Exception {
		return 0;
	}

	public int updateDistributorDOBalance(DistributorDO distributorDO) {
		return 0;
	}

	public List<DistributorDO> selectDistributorDOByNameLike(String name) throws Exception {
		return null;
	}
}
