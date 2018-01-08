package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.SubsiteDO;
import com.zhezhuo.model.query.SubsiteQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public interface SubsiteManager {

	/**
	 * 消费者在店铺使用优惠券
	 * @param subsiteDO
	 * @return
	 * @throws Exception
	 */
	Result<Integer> editSubsite(SubsiteDO subsiteDO) throws Exception;
	
	/**
	 * 根据优惠券号码查询优惠券
	 * @param subId
	 * @return
	 * @throws Exception
	 */
	SubsiteDO querySubsiteBysubNUM(String subNUM) throws Exception;
	
	/**
	 * 查询在本店铺中使用的优惠券
	 * @param shopsId
	 * @return
	 * @throws Exception
	 */
	Result<List<SubsiteDO>> querySubsiteByshopsIdList(SubsiteQuery query) throws Exception;
	
	/**
	 * 查询在本店铺消费的优惠券总数
	 * @param shopsId
	 * @return
	 * @throws Exception
	 */
	List<SubsiteDO> selectSubsiteByShopIds(long shopsId) throws Exception;
	/**
	 * 查询所有已经使用过的优惠券
	 * @param query
	 * @return
	 */
	List<SubsiteDO> selectSubsiteList(SubsiteQuery query);
	/**
	 * 根据优惠券状态查询相应的额优惠券的数量
	 * @param status
	 * @return
	 */
	List<SubsiteDO> selectSubsiteByStatus(int status);
}
