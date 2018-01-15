package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.HqCommissionDO;
import com.aishidai.app.model.pojo.HqCommissionDOCustom;
import com.aishidai.app.model.pojo.MakerCommissionDetailDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDOCustom;
import com.aishidai.app.model.pojo.ShopCommissionDO;
import com.aishidai.app.model.pojo.ShopCommissionDOCustom;
import com.aishidai.app.model.query.HqCommissionQuery;
import com.aishidai.app.model.query.OtherShopCommissionQuery;
import com.aishidai.app.model.query.ShopCommissionQuery;


public interface CommissionService {

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
	

	List<ShopCommissionDOCustom> queryShopCommissionDOList(ShopCommissionQuery query);

	long queryShopCommissionDOListCount(ShopCommissionQuery query);
	
	public List<OtherShopCommissionDOCustom> queryOtherShopCommissionDOList(OtherShopCommissionQuery query);
	public long queryOtherShopCommissionDOListCount(OtherShopCommissionQuery query);
	
	List<HqCommissionDOCustom> queryHqCommissionList(HqCommissionQuery query) throws Exception;
	
	long queryHqCommissionCount(HqCommissionQuery query) throws Exception;
}
