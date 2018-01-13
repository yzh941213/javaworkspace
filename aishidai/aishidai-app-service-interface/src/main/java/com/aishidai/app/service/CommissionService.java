package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.HqCommissionDO;
import com.aishidai.app.model.pojo.MakerCommissionDetailDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDO;
import com.aishidai.app.model.pojo.ShopCommissionDO;
import com.aishidai.app.model.query.HqCommissionQuery;
import com.aishidai.app.model.query.OtherShopCommissionQuery;
import com.aishidai.app.model.query.ShopCommissionQuery;


public interface CommissionService {

	
	/*List<ShopCommissionDO> queryShopCommissionList(ShopCommissionQuery query)throws Exception;
	
	int queryShopCommissionCount(ShopCommissionQuery query)throws Exception;
	
	
	List<OtherShopCommissionDO> queryOtherShopCommissionList(OtherShopCommissionQuery query) throws Exception;
	
	int queryOtherShopCommissionCount(OtherShopCommissionQuery query)throws Exception;
	
	
	List<OtherShopCommissionDO> queryHqCommissionList(HqCommissionQuery query) throws Exception;
	
	int queryHqCommissionCount(HqCommissionQuery query) throws Exception;
	
	
	List<ShopCommissionDO> queryShopCommissionListbByHq(ShopCommissionQuery query) throws Exception;
	
	int queryShopCommissionCountByHq(ShopCommissionQuery query) throws Exception;
	
	
	List<OtherShopCommissionDO> queryOtherShopCommissionListByHq(OtherShopCommissionQuery query) throws Exception;
	
	int queryOtherShopCommissionCountByHq(OtherShopCommissionQuery query) throws Exception;
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	List<MakerCommissionDetailDO> queryMakerCommissionDOByShopId(long shopsId) throws Exception;
	
	HqCommissionDO queryHqCommissionDOById(long id) throws Exception;
	
	ShopCommissionDO queryShopCommissionDOById(long id) throws Exception;
	
	List<MakerCommissionDetailDO> queryMakerCommissionDOByOtherShopId(long otherShopId) throws Exception;
	
	OtherShopCommissionDO queryOtherShopCommissionDOById(long id)throws Exception;
	
	boolean editMakerCommissionDOShop(MakerCommissionDetailDO record)throws Exception;
	
	boolean editShopCommissionDO(ShopCommissionDO SCDO) throws Exception;
	
	boolean editOtherShopCommissionDO(OtherShopCommissionDO OSCD) throws Exception;
	
	boolean editHqCommissionDO(HqCommissionDO HCD) throws Exception;
	
	MakerCommissionDetailDO queryMakerCommissionDetailDOById(long id) throws Exception;
	
	boolean addHqCommissionDO(HqCommissionDO hQC) throws Exception;
	
	OtherShopCommissionDO queryOtherShopCommissionDOByOtherShopId(long otherShopId) throws Exception;
	
	boolean insertOtherShopCommissionDO(OtherShopCommissionDO otherShopCommissionDO)throws Exception;

	boolean insertShopCommissionDO(ShopCommissionDO shopCommissionDO)throws Exception;

	boolean insertMakerCommissionDetailDOOtherShop(String makerValue,long otherShopId,long userId)throws Exception;

	boolean insertMakerCommissionDetailDOShop(String makerValue, long shopId,long userId)throws Exception;

	int removeMakerCommissionDetailDO(long id) throws Exception;

	ShopCommissionDO queryShopCommissionDOByShopId(long shopId);
}
