package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.ServicesDO;
import com.zhezhuo.model.query.ServicesQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface ServicesDAO {

	public List<ServicesDO> queryServicesDOList(ServicesQuery query) throws Exception;

	public ServicesDO queryServicesDOById(long servicesId) throws Exception;

	public long editServicesDO(ServicesDO servicesDO) throws Exception;

	public int updateServicesDOStatus(ServicesDO servicesDO) throws Exception;

	public List<ServicesDO> queryServicesDOByShopId(long shopId) throws Exception;

}
