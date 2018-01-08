package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.CraftsmenDAO;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.query.CraftsmenQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class CraftsmenDAOImpl extends BaseDAO implements CraftsmenDAO {
	public List<CraftsmenDO> queryCraftsmenDOList(CraftsmenQuery query) throws Exception {
		return null;
	}

	public CraftsmenDO queryCraftsmenDOById(long craftsmenId) throws Exception {
		return null;
	}

	public CraftsmenDO queryCraftsmenDOBySysUserId(long sysUserId) throws Exception {
		return null;
	}

	public long editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception {
		return 0;
	}

	public int updateCraftsmenDOStatus(CraftsmenDO craftsmenDO) throws Exception {
		return 0;
	}

	public List<CraftsmenDO> queryCraftsmenDOByDistributorId(long distributorId) throws Exception {
		return null;
	}

	public List<CraftsmenDO> queryCraftsmenDOByShopId(long shopId) throws Exception {
		return null;
	}

	public long updateCraftsmenDOSysUserId(CraftsmenDO craftsmenDO) {
		return 0;
	}

	public Long queryCraftsmenCount() {
		return null;
	}

	public Long queryCraftsmenCountByDistributor(Long id) {
		return null;
	}

	public Long queryCraftsmenCountByShop(Long shopsId) {
		return null;
	}

	public Long queryCraftsmenCountByMaker(Long id) {
		return null;
	}

	public int updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO) {
		return 0;
	}

	public int updateCraftsmanDOAmount(CraftsmenDO craftsmenDO) {
		return 0;
	}

	public int updateCraftsmanDOBalance(CraftsmenDO craftsmenDO) {
		return 0;
	}

	public int updateCraftsmenAudit(CraftsmenDO craftsmenDO) throws Exception {
		return 0;
	}
}
