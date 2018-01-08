package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.MakerDAO;
import com.zhezhuo.model.entity.DeviceMakerDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.query.DeviceMakerQuery;
import com.zhezhuo.model.query.MakerQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class MakerDAOImpl extends BaseDAO implements MakerDAO {
	public List<MakerDO> queryMakerDOList(MakerQuery query) throws Exception {
		return null;
	}

	public MakerDO queryMakerDOById(long shopId) throws Exception {
		return null;
	}

	public MakerDO queryMakerDOBySysUserId(long sysUserId) throws Exception {
		return null;
	}

	public long editMakerDO(MakerDO makerDO) throws Exception {
		return 0;
	}

	public int updateMakerDOStatus(MakerDO makerDO) throws Exception {
		return 0;
	}

	public List<MakerDO> queryMakerDOByDistributorId(long distributorId) throws Exception {
		return null;
	}

	public Long updateMakerDOSysUserId(MakerDO makerDO) throws Exception {
		return null;
	}

	public Long queryMakerCount() throws Exception {
		return null;
	}

	public Long queryMakerCountByDistributor(Long id) throws Exception {
		return null;
	}

	public List<MakerDO> queryMakerDOAll(MakerQuery query) throws Exception {
		return null;
	}

	public int updateMakerDOAmount(MakerDO makerDO) throws Exception {
		return 0;
	}

	public int updateMakerDOBalance(MakerDO makerDO) {
		return 0;
	}

	public int updateMakerDOAudit(MakerDO makerDO) throws Exception {
		return 0;
	}

	public List<MakerDO> selectMakerDOByNameLike(MakerDO makerDO) throws Exception {
		return null;
	}

	public long insetDeviceMaker(DeviceMakerDO deviceMakerDO) throws Exception {
		return 0;
	}

	public List<DeviceMakerDO> selectDeviceMaker(DeviceMakerQuery query) throws Exception {
		return null;
	}

	public int delDeviceMaker(DeviceMakerDO deviceMakerDO) throws Exception {
		return 0;
	}
}
