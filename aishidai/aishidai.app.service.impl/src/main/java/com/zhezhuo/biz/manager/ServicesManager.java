package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ServicesDO;
import com.zhezhuo.model.query.ServicesQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface ServicesManager {

	public Result<List<ServicesDO>> queryServicesDOList(ServicesQuery query);

	public Result<ServicesDO> queryServicesDOById(long servicesId);

	public Result<Long> editServicesDO(ServicesDO servicesDO);

	public Result<Integer> updateServicesStatus(ServicesDO servicesDO);

	public Result<List<ServicesDO>> queryServicesDOByShopId(long shopId);
}
