package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.HqCommissionDO;
import com.zhezhuo.model.entity.MakerCommissionDetailDO;
import com.zhezhuo.model.entity.OtherShopCommissionDO;
import com.zhezhuo.model.entity.ShopCommissionDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.query.HqCommissionQuery;
import com.zhezhuo.model.query.OtherShopCommissionQuery;
import com.zhezhuo.model.query.ShopCommissionQuery;

public interface CommissionManager {

	/**
	 * 插入异业店铺分成
	 * @param otherShopCommissionDO
	 * @return
	 */
	void insetOtherShopCommissionDO(OtherShopCommissionDO otherShopCommissionDO)throws Exception;
	/**
	 * 插入店铺分成
	 * @param shopCommissionDO
	 * @return
	 */
	void insetShopCommissionDO(ShopCommissionDO shopCommissionDO)throws Exception;
	
	/**
	 * 根据创客ID修改
	 * @param makerId
	 * @return
	 */
	int updateMakerCommissionDetailDOByShopId(long makerId)throws Exception;
	
	/**
	 * 插入异业店铺的创客分成数据
	 * @param makerValue
	 * @param otherShopId
	 */
	void insetMakerCommissionDetailDOOtherShop(String makerValue,long otherShopId,long sysUserId)throws Exception;
	/**
	 * 插入店铺的创客分成数据
	 * @param makerValue
	 * @param shopId
	 */
	void insetMakerCommissionDetailDOShop(String makerValue, long shopId,long sysUserId)throws Exception;
	
	/**
	 * 根据shopId查询数据
	 * @param shopId
	 * @return
	 */
	ShopCommissionDO queryShopCommissionDOByShopId(long shopId)throws Exception;
	/**
	 * 根据otherShopId数据查询
	 * @param otherShopId
	 * @return
	 */
	OtherShopCommissionDO queryShopCommissionDOByOtherShopId(long otherShopId) throws Exception;
	
	/**
	 * 查询店铺分成列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ShopCommissionDO> queryShopCommissionList(ShopCommissionQuery query)throws Exception;
	/**
	 * 查询店铺分成列表数量
	 * @param query
	 * @return
	 * @throws Exception
	 */
	int queryShopCommissionCount(ShopCommissionQuery query)throws Exception;
	/**
	 * 查询异业店铺分成列表
	 * @param query
	 * @return
	 */
	List<OtherShopCommissionDO> queryOtherShopCommissionList(OtherShopCommissionQuery query) throws Exception;
	/**
	 * 查询异业店铺分成数量
	 * @param query
	 * @return
	 */
	int queryOtherShopCommissionCount(OtherShopCommissionQuery query)throws Exception;
	
	/**
	 * 查询异业分成详情
	 * @param shopsId
	 * @return
	 * @throws Exception
	 */
	OtherShopCommissionDO queryOtherShopCommissionDOById(String id)throws Exception;
	/**
	 * 查询店铺分页详情
	 * @param id
	 * @return
	 */
	ShopCommissionDO queryShopCommissionDOById(String id) throws Exception;
	/**
	 * 查询异业关联的数据
	 * @param otherShopId
	 * @return
	 * @throws Exception
	 */
	List<MakerCommissionDetailDO> queryMakerCommissionDOByOtherShopId(
			Long otherShopId) throws Exception;
	/**
	 * 查询店铺关联的数据
	 * @param shopId
	 * @return
	 */
	List<MakerCommissionDetailDO> queryMakerCommissionDOByShopId(Long shopId) throws Exception;
	/**
	 * 总部查询分成列表
	 * @param query
	 * @return
	 */
	List<OtherShopCommissionDO> queryHqCommissionList(HqCommissionQuery query) throws Exception;
	/**
	 * 总部查询分成列表总数量
	 * @param query
	 * @return
	 */
	int queryHqCommissionCount(HqCommissionQuery query) throws Exception;
	/**
	 * 总部查询单个分成
	 * @param id
	 * @return
	 */
	HqCommissionDO queryHqCommissionDOById(String id) throws Exception;
	/**
	 * 总部插入分成数据
	 * @param hQC
	 * @throws Exception
	 */
	void addHqCommissionDO(HqCommissionDO hQC) throws Exception;
	/**
	 * 
	 * @param hCD
	 * @return
	 * @throws Exception
	 */
	int editHqCommissionDO(HqCommissionDO hCD) throws Exception;
	/**
	 * 修改创客的分成有关于店铺
	 * @param makerValue
	 * @return
	 * @throws Exception
	 */
	int editMakerCommissionDOShop(String makerValue)throws Exception;
	
	/**
	 * 删除HqCommissionDO
	 * @param del
	 * @return
	 * @throws Exception
	 */
	int delHqCommissionDO(HqCommissionDO hqd) throws Exception;
	
	MakerCommissionDetailDO queryMakerCommissionDetailDOById(String id) throws Exception;
	
	int delMakerCommissionDetailDO(MakerCommissionDetailDO result) throws Exception;
	
	int delShopCommissionDO(ShopCommissionDO result_shop) throws Exception;
	
	int delOtherShopCommissionDO(OtherShopCommissionDO result_otherShop)throws Exception;
	
	int editShopCommissionDO(ShopCommissionDO sCDO) throws Exception;
	
	int editOtherShopCommissionDO(OtherShopCommissionDO oSCD) throws Exception;
	//删除创客的单个数据分成
	int removeMakerCommissionDetailDO(MakerCommissionDetailDO make) throws Exception;
	
	List<ShopCommissionDO> queryShopCommissionListbByHq(
			ShopCommissionQuery query) throws Exception;
	
	int queryShopCommissionCountByHq(ShopCommissionQuery query) throws Exception;
	
	List<OtherShopCommissionDO> queryOtherShopCommissionListByHq(
			OtherShopCommissionQuery query) throws Exception;
	
	int queryOtherShopCommissionCountByHq(OtherShopCommissionQuery query) throws Exception;
	
	OtherShopCommissionDO queryOtherShopCommissionDOByOtherShopId(
			long otherShopId) throws Exception;
	
}
