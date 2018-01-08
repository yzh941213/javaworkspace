package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.HqCommissionDO;
import com.zhezhuo.model.entity.MakerCommissionDetailDO;
import com.zhezhuo.model.entity.OtherShopCommissionDO;
import com.zhezhuo.model.entity.ShopCommissionDO;
import com.zhezhuo.model.query.HqCommissionQuery;
import com.zhezhuo.model.query.OtherShopCommissionQuery;
import com.zhezhuo.model.query.ShopCommissionQuery;

public interface CommissionDAO {
	/**
	 * 查询异业分成表
	 * @param otherShopId
	 * @return
	 */
	OtherShopCommissionDO selectOtherShopCommissionDOByOtherShopId(
			long otherShopId) throws Exception;

	/**
	 * 查询店铺分成表
	 * @param otherShopId
	 * @return
	 */
	ShopCommissionDO selectShopCommissionDOByShopId(long shopId) throws Exception;
	
	/**
	 * 根据创客ID查询创客分成详细
	 * @param makerId
	 * @return
	 */
	List<MakerCommissionDetailDO> selectMakerCommissionDetailDOListByShopId(long makerId) throws Exception;
	
	/**
	 * 根据创客ID修改
	 * @param makerId
	 * @return
	 */
	int updateMakerCommissionDetailDOByShopId(long makerId) throws Exception;
	/**
	 * 插入异业店铺分成
	 * @param otherShopCommissionDO
	 * @return
	 */
	void insetOtherShopCommissionDO(OtherShopCommissionDO otherShopCommissionDO) throws Exception;
	/**
	 * 插入店铺分成
	 * @param shopCommissionDO
	 * @return
	 */
	void insetShopCommissionDO(ShopCommissionDO shopCommissionDO) throws Exception;
	
	/**
	 * 插入详细分成
	 * @param makerCommissionDetailDO
	 * @return
	 */
	void insetMakerCommissionDetailDO(MakerCommissionDetailDO makerCommissionDetailDO) throws Exception;

	/**
	 * 查询店铺分成列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ShopCommissionDO> selectShopCommissionDOList(ShopCommissionQuery query) throws Exception;
	/**
	 * 查询异业店铺分成列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<OtherShopCommissionDO> selectOtherShopCommissionDOList(
			OtherShopCommissionQuery query) throws Exception;
	/**
	 * 查询店铺分成的数量
	 * @param query
	 * @return
	 */
	int selectShopCommissionCount(ShopCommissionQuery query) throws Exception;
	
	/**
	 * 查询异业分成数量
	 * @param query
	 * @return
	 */
	int selectOtherShopCommissionCount(OtherShopCommissionQuery query) throws Exception;
	/**
	 * 查询异业分成详情
	 * @param id
	 * @return
	 */
	OtherShopCommissionDO selectOtherShopCommissionDOById(String id) throws Exception;
	/**
	 * 查询店铺分成查询
	 * @param id
	 * @return
	 */
	ShopCommissionDO selectShopCommissionDOById(String id) throws Exception;

	List<MakerCommissionDetailDO> selectMakerCommissionDOByOtherShopId(
			Long otherShopId) throws Exception;

	List<MakerCommissionDetailDO> selectMakerCommissionDOByShopId(Long shopId)throws Exception;

	List<OtherShopCommissionDO> selectHqCommissionList(
			HqCommissionQuery query) throws Exception;

	int selectHqCommissionListCount(HqCommissionQuery query) throws Exception;

	HqCommissionDO selectHqCommissionDOById(String id) throws Exception;

	void insetHqCommissionDO(HqCommissionDO hQC) throws Exception;

	int updateHqCommissionDO(HqCommissionDO hCD) throws Exception;
	
	int delHqCommissionDO(HqCommissionDO hqd) throws Exception;

	MakerCommissionDetailDO selectMakerCommissionDetailDOById(String id) throws Exception;

	int delMakerCommissionDetailDO(MakerCommissionDetailDO result) throws Exception;

	int delShopCommissionDO(ShopCommissionDO result_shop) throws Exception;

	int delOtherShopCommissionDO(OtherShopCommissionDO result_otherShop) throws Exception;

	int updateShopCommissionDO(ShopCommissionDO sCDO) throws Exception;

	int updateOtherShopCommissionDO(OtherShopCommissionDO oSCD) throws Exception;

	int removeMakerCommissionDetailDO(MakerCommissionDetailDO make) throws Exception;

	List<ShopCommissionDO> selectShopCommissionListbByHq(
			ShopCommissionQuery query) throws Exception;

	int selectShopCommissionCountByHq(ShopCommissionQuery query) throws Exception;

	List<OtherShopCommissionDO> selectOtherShopCommissionListByHq(
			OtherShopCommissionQuery query) throws Exception;

	int selectOtherShopCommissionCountByHq(OtherShopCommissionQuery query) throws Exception;

	OtherShopCommissionDO selectOtherShopCommissionDOByShopId(long otherShopId) throws Exception;

}
