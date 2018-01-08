package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.SubsiteDO;
import com.zhezhuo.model.query.SubsiteQuery;

/**
 * 消费者消费卡包的优惠券
 * @author 51147
 *
 */
public interface SubsiteDAO {

	/**
	 * 消费者在店铺使用优惠券
	 * @param subsiteDO
	 * @return
	 * @throws Exception
	 */
	Integer editSubsite(SubsiteDO subsiteDO) throws Exception;

	/**
	 * 根据优惠券号码查询优惠券
	 * @param subId
	 * @return
	 * @throws Exception
	 */
	SubsiteDO querySubsiteBysubNUM(String subNUM) throws Exception;
	
	/**
	 * 店铺查看在自己店铺消费的优惠券
	 * @param shopsId
	 * @return
	 * @throws Exception
	 */
	List<SubsiteDO> querySubsiteByshopsIdList(SubsiteQuery query) throws Exception;

	/**
	 *查询在本店铺消费的优惠券的总数
	 * @param shopsId
	 * @return
	 * @throws Exception
	 */
	List<SubsiteDO> selectSubsiteByShopIds(long shopsId) throws Exception;
	
	/**
	 * 查询所有优惠券
	 * @param query
	 * @return
	 */
	List<SubsiteDO> querySubsiteList(SubsiteQuery query);
	
	/**
	 * 根据优惠券状态查询优惠券数量
	 * @param status
	 * @return
	 */
	List<SubsiteDO> selectSubsiteByStatus(int status);
	
}
