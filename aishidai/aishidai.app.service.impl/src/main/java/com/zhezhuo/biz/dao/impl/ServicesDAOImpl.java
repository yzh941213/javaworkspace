package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.ServicesDAO;
import com.zhezhuo.model.entity.ServicesDO;
import com.zhezhuo.model.query.ServicesQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class ServicesDAOImpl extends BaseDAO implements ServicesDAO {
	public List<ServicesDO> queryServicesDOList(ServicesQuery query) throws Exception {
		return null;
	}

	public ServicesDO queryServicesDOById(long servicesId) throws Exception {
		return null;
	}

	public long editServicesDO(ServicesDO servicesDO) throws Exception {
		return 0;
	}

	public int updateServicesDOStatus(ServicesDO servicesDO) throws Exception {
		return 0;
	}

	public List<ServicesDO> queryServicesDOByShopId(long shopId) throws Exception {
		return null;
	}
}
