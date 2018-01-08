package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.SubsiteDAO;
import com.zhezhuo.model.entity.SubsiteDO;
import com.zhezhuo.model.query.SubsiteQuery;

/**
 * 消费者，消费卡包中的 优惠券
 * 
 * @author 51147
 *
 */
public class SubsiteDAOImpl extends BaseDAO implements SubsiteDAO {
	public Integer editSubsite(SubsiteDO subsiteDO) throws Exception {
		return null;
	}

	public SubsiteDO querySubsiteBysubNUM(String subNUM) throws Exception {
		return null;
	}

	public List<SubsiteDO> querySubsiteByshopsIdList(SubsiteQuery query) throws Exception {
		return null;
	}

	public List<SubsiteDO> selectSubsiteByShopIds(long shopsId) throws Exception {
		return null;
	}

	public List<SubsiteDO> querySubsiteList(SubsiteQuery query) {
		return null;
	}

	public List<SubsiteDO> selectSubsiteByStatus(int status) {
		return null;
	}
}
