package com.aishidai.app.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.CommissionDAO;
import com.zhezhuo.biz.dao.MakerDAO;
import com.zhezhuo.biz.manager.CommissionManager;
import com.zhezhuo.model.entity.HqCommissionDO;
import com.zhezhuo.model.entity.MakerCommissionDetailDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.OtherShopCommissionDO;
import com.zhezhuo.model.entity.ShopCommissionDO;
import com.zhezhuo.model.query.HqCommissionQuery;
import com.zhezhuo.model.query.OtherShopCommissionQuery;
import com.zhezhuo.model.query.ShopCommissionQuery;

public class CommissionServiceImpl implements CommissionManager {

	@Autowired
	private CommissionDAO commissionDAO;
	@Autowired
	private MakerDAO makerDAO;
	
	
	public void insetOtherShopCommissionDO(
			OtherShopCommissionDO otherShopCommissionDO) throws Exception {
		// TODO Auto-generated method stub
		commissionDAO.insetOtherShopCommissionDO(otherShopCommissionDO);
	}

	
	public void insetShopCommissionDO(ShopCommissionDO shopCommissionDO) throws Exception {
		// TODO Auto-generated method stub
		commissionDAO.insetShopCommissionDO(shopCommissionDO);
	}


	//TODO
	
	public int updateMakerCommissionDetailDOByShopId(long makerId) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.updateMakerCommissionDetailDOByShopId(makerId);
	}

	
	public void insetMakerCommissionDetailDOOtherShop(String makerValue,
			long otherShopId,long sysUserId) throws Exception {
		// TODO Auto-generated method stub
		MakerCommissionDetailDO cdd = new MakerCommissionDetailDO();
		
		String checkBox[] = makerValue.split(";");
		
		for (int i = 0; i < checkBox.length; i++) {
			
			String check =  checkBox[i];
			String[] keyValue = check.split(":");
			String makerId = keyValue[0];
			String value = keyValue[1];
			
			MakerDO maker = makerDAO.queryMakerDOById(Long.valueOf(makerId));
			
			
			cdd.setMakerId(Long.valueOf(makerId));
			cdd.setCommission(Integer.valueOf(value));
			cdd.setDeleteIs(0);
			cdd.setMakerName(maker.getName());
			cdd.setCreateId(sysUserId);
			cdd.setId(Tools.getGuid());
			cdd.setOtherShopId(otherShopId);
			cdd.setType(1);
			commissionDAO.insetMakerCommissionDetailDO(cdd);
		}
	}

	
	public void insetMakerCommissionDetailDOShop(String makerValue, long shopId,long sysUserId) throws Exception {
		// TODO Auto-generated method stub
		MakerCommissionDetailDO cdd = new MakerCommissionDetailDO();
		
		String checkBox[] = makerValue.split(";");
		
		for (int i = 0; i < checkBox.length; i++) {
			
			String check =  checkBox[i];
			String[] keyValue = check.split(":");
			String makerId = keyValue[0];
			String value = keyValue[1];
			
			
			MakerDO maker = makerDAO.queryMakerDOById(Long.valueOf(makerId));
			
			cdd.setMakerId(Long.valueOf(makerId));
			cdd.setCommission(Integer.valueOf(value));
			cdd.setDeleteIs(0);
			cdd.setMakerName(maker.getName());
			
			cdd.setId(Tools.getGuid());
			cdd.setCreateId(sysUserId);
			cdd.setShopId(shopId);
			cdd.setType(0);
			commissionDAO.insetMakerCommissionDetailDO(cdd);
		}
	}

	
	public ShopCommissionDO queryShopCommissionDOByShopId(long shopId) throws Exception {
		// TODO Auto-generated method stub
		
		ShopCommissionDO SCO = commissionDAO.selectShopCommissionDOByShopId(shopId);
		return SCO;
	}

	
	public OtherShopCommissionDO queryShopCommissionDOByOtherShopId(long otherShopId) throws Exception {
		// TODO Auto-generated method stub
		OtherShopCommissionDO OSO = commissionDAO.selectOtherShopCommissionDOByOtherShopId(otherShopId);
		return OSO;
	}

	
	public List<ShopCommissionDO> queryShopCommissionList(
			ShopCommissionQuery query) throws Exception {
		List<ShopCommissionDO> result = commissionDAO.selectShopCommissionDOList(query);
		return result;
	}

	
	public int queryShopCommissionCount(ShopCommissionQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectShopCommissionCount(query);
	}

	
	public List<OtherShopCommissionDO> queryOtherShopCommissionList(
			OtherShopCommissionQuery query) throws Exception {
		List<OtherShopCommissionDO> result = commissionDAO.selectOtherShopCommissionDOList(query);
		return result;
	}

	
	public int queryOtherShopCommissionCount(OtherShopCommissionQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectOtherShopCommissionCount(query);
	}

	
	public OtherShopCommissionDO queryOtherShopCommissionDOById(String id)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectOtherShopCommissionDOById(id);
	}

	
	public ShopCommissionDO queryShopCommissionDOById(String id) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectShopCommissionDOById(id);
	}

	
	public List<MakerCommissionDetailDO> queryMakerCommissionDOByOtherShopId(
			Long otherShopId) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectMakerCommissionDOByOtherShopId(otherShopId);
	}

	
	public List<MakerCommissionDetailDO> queryMakerCommissionDOByShopId(
			Long shopId) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectMakerCommissionDOByShopId(shopId);
	}

	
	public List<OtherShopCommissionDO> queryHqCommissionList(
			HqCommissionQuery query) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectHqCommissionList(query);
	}

	
	public int queryHqCommissionCount(HqCommissionQuery query) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectHqCommissionListCount(query);
	}

	
	public HqCommissionDO queryHqCommissionDOById(String id) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectHqCommissionDOById(id);
	}

	
	public void addHqCommissionDO(HqCommissionDO hQC) throws Exception {
		// TODO Auto-generated method stub
		commissionDAO.insetHqCommissionDO(hQC);
	}

	
	public int editHqCommissionDO(HqCommissionDO hCD) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.updateHqCommissionDO(hCD);
	}

	
	public int editMakerCommissionDOShop(String makerValue) throws Exception {
		// TODO Auto-generated method stub
		MakerCommissionDetailDO cdd = new MakerCommissionDetailDO();
		
		String checkBox[] = makerValue.split(";");
		return 0;
	}

	
	public int delHqCommissionDO(HqCommissionDO hqd) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.delHqCommissionDO(hqd);
	}

	
	public MakerCommissionDetailDO queryMakerCommissionDetailDOById(String id)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectMakerCommissionDetailDOById(id);
	}

	
	public int delMakerCommissionDetailDO(MakerCommissionDetailDO result)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.delMakerCommissionDetailDO(result);
	}

	
	public int delShopCommissionDO(ShopCommissionDO result_shop)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.delShopCommissionDO(result_shop);
	}

	
	public int delOtherShopCommissionDO(OtherShopCommissionDO result_otherShop)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.delOtherShopCommissionDO(result_otherShop);
	}

	
	public int editShopCommissionDO(ShopCommissionDO SCDO) throws Exception {
		// TODO Auto-generated method stub
		
		return commissionDAO.updateShopCommissionDO(SCDO);
	}

	
	public int editOtherShopCommissionDO(OtherShopCommissionDO oSCD)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.updateOtherShopCommissionDO(oSCD);
	}

	
	public int removeMakerCommissionDetailDO(MakerCommissionDetailDO make)
			throws Exception {
		// TODO Auto-generated method stub
		
		return commissionDAO.removeMakerCommissionDetailDO(make);
	}

	
	public List<ShopCommissionDO> queryShopCommissionListbByHq(
			ShopCommissionQuery query) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectShopCommissionListbByHq(query);
	}

	
	public int queryShopCommissionCountByHq(ShopCommissionQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectShopCommissionCountByHq(query);
	}

	
	public List<OtherShopCommissionDO> queryOtherShopCommissionListByHq(
			OtherShopCommissionQuery query) throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectOtherShopCommissionListByHq(query);
	}

	
	public int queryOtherShopCommissionCountByHq(OtherShopCommissionQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		return commissionDAO.selectOtherShopCommissionCountByHq(query);
	}

	
	public OtherShopCommissionDO queryOtherShopCommissionDOByOtherShopId(
			long otherShopId) throws Exception {
		// TODO Auto-generated method stub
		OtherShopCommissionDO OSCO = commissionDAO.selectOtherShopCommissionDOByShopId(otherShopId);
		return OSCO;
	}
}
