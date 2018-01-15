package com.aishidai.app.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.HqCommissionDOCustomMapper;
import com.aishidai.app.dao.HqCommissionDOMapper;
import com.aishidai.app.dao.MakerCommissionDetailDOCustomMapper;
import com.aishidai.app.dao.MakerCommissionDetailDOMapper;
import com.aishidai.app.dao.MakerDOMapper;
import com.aishidai.app.dao.OtherShopCommissionDOCustomMapper;
import com.aishidai.app.dao.OtherShopCommissionDOMapper;
import com.aishidai.app.dao.ShopCommissionDOCustomMapper;
import com.aishidai.app.dao.ShopCommissionDOMapper;
import com.aishidai.app.model.pojo.HqCommissionDO;
import com.aishidai.app.model.pojo.HqCommissionDOCustom;
import com.aishidai.app.model.pojo.MakerCommissionDetailDO;
import com.aishidai.app.model.pojo.MakerCommissionDetailDOExample;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDOCustom;
import com.aishidai.app.model.pojo.OtherShopCommissionDOExample;
import com.aishidai.app.model.pojo.ShopCommissionDO;
import com.aishidai.app.model.pojo.ShopCommissionDOCustom;
import com.aishidai.app.model.pojo.ShopCommissionDOExample;
import com.aishidai.app.model.query.HqCommissionQuery;
import com.aishidai.app.model.query.OtherShopCommissionQuery;
import com.aishidai.app.model.query.ShopCommissionQuery;
import com.aishidai.app.service.CommissionService;

@Service
public class CommissionServiceImpl implements CommissionService {

	@Autowired
	private ShopCommissionDOMapper shopCommissionDOMapper;
	@Autowired
	private HqCommissionDOMapper hqCommissionDOMapper;
	@Autowired
	private MakerCommissionDetailDOMapper makerCommissionDetailDOMapper;
	@Autowired
	private OtherShopCommissionDOMapper otherShopCommissionDOMapper;
	@Autowired
	private ShopCommissionDOCustomMapper shopCommissionDOCustomMapper;
	@Autowired
	private HqCommissionDOCustomMapper hqCommissionDOCustomMapper;
	@Autowired
	private MakerCommissionDetailDOCustomMapper makerCommissionDetailDOCustomMapper;
	@Autowired
	private OtherShopCommissionDOCustomMapper otherShopCommissionDOCustomMapper;
	@Autowired
	private MakerDOMapper makerDOMapper;
	
	
	
	
	
	public boolean insertOtherShopCommissionDO(OtherShopCommissionDO otherShopCommissionDO) throws Exception {
		return otherShopCommissionDOCustomMapper.insertOtherShopCommissionDO(otherShopCommissionDO)>0;
	}

	
	public boolean insertShopCommissionDO(ShopCommissionDO shopCommissionDO) throws Exception {
		
		return shopCommissionDOCustomMapper.insertShopCommissionDO(shopCommissionDO)>0;
	}


	public boolean insertMakerCommissionDetailDOOtherShop(String makerValue,
			long otherShopId,long userId) throws Exception {
		
		MakerCommissionDetailDO cdd = new MakerCommissionDetailDO();
		
		String checkBox[] = makerValue.split(";");
		int result = 0;
		
		for (int i = 0; i < checkBox.length; i++) {
			
			String check =  checkBox[i];
			String[] keyValue = check.split(":");
			String makerId = keyValue[0];
			String value = keyValue[1];
			
			MakerDO maker = makerDOMapper.selectByPrimaryKey(Long.valueOf(makerId));
			
			cdd.setMakerId(Long.valueOf(makerId));
			cdd.setCommission(Integer.valueOf(value));
			cdd.setIsDelete(0);
			cdd.setMakerName(maker.getName());
			cdd.setCreateId(userId);
			cdd.setOtherShopId(otherShopId);
			cdd.setType(1);
			makerCommissionDetailDOCustomMapper.insertMakerCommissionDetailDO(cdd);
		}
		return result>0?true:false;
	}

	
	public boolean insertMakerCommissionDetailDOShop(String makerValue, long shopId,long userId) throws Exception {
		
		MakerCommissionDetailDO cdd = new MakerCommissionDetailDO();
		
		String checkBox[] = makerValue.split(";");
		int result = 0;
		
		for (int i = 0; i < checkBox.length; i++) {
			
			String check =  checkBox[i];
			String[] keyValue = check.split(":");
			String makerId = keyValue[0];
			String value = keyValue[1];
			MakerDO maker = makerDOMapper.selectByPrimaryKey(Long.valueOf(makerId));
			cdd.setMakerId(Long.valueOf(makerId));
			cdd.setCommission(Integer.valueOf(value));
			cdd.setIsDelete(0);
			cdd.setMakerName(maker.getName());
			cdd.setCreateId(userId);
			cdd.setShopId(shopId);
			cdd.setType(0);
			makerCommissionDetailDOCustomMapper.insertMakerCommissionDetailDO(cdd);
		}
		return result>0?true:false;
	}

	
	

	
	public OtherShopCommissionDO queryOtherShopCommissionDOById(long id)
			throws Exception {
		return otherShopCommissionDOMapper.selectByPrimaryKey(id);
	}

	
	public ShopCommissionDO queryShopCommissionDOById(long id) throws Exception {
		return shopCommissionDOMapper.selectByPrimaryKey(id);
	}

	
	public List<MakerCommissionDetailDO> queryMakerCommissionDOByOtherShopId(
			long otherShopId) throws Exception {
		MakerCommissionDetailDOExample example = new MakerCommissionDetailDOExample();
		MakerCommissionDetailDOExample.Criteria criteria= example.createCriteria();
		criteria.andOtherShopIdEqualTo(otherShopId);
		criteria.andIsDeleteEqualTo(0);
		return makerCommissionDetailDOMapper.selectByExample(example);
	}

	
	public List<MakerCommissionDetailDO> queryMakerCommissionDOByShopId(
			long shopId) throws Exception {
		MakerCommissionDetailDOExample example = new MakerCommissionDetailDOExample();
		MakerCommissionDetailDOExample.Criteria criteria= example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		criteria.andIsDeleteEqualTo(0);
		return makerCommissionDetailDOMapper.selectByExample(example);
	}

	
	public HqCommissionDO queryHqCommissionDOById(long id) throws Exception {
		
		return hqCommissionDOMapper.selectByPrimaryKey(id);
	}

	
	public boolean addHqCommissionDO(HqCommissionDO hqc) throws Exception {
		
		return hqCommissionDOCustomMapper.insertHqCommissionDO(hqc)>0;
	}

	
	public boolean editHqCommissionDO(HqCommissionDO hqc) throws Exception {
		
		return hqCommissionDOMapper.updateByPrimaryKeySelective(hqc) > 0;
	}
	
	public boolean editMakerCommissionDOShop(MakerCommissionDetailDO record) throws Exception {
		
		return makerCommissionDetailDOMapper.updateByPrimaryKeySelective(record)>0;
	}
	
	public MakerCommissionDetailDO queryMakerCommissionDetailDOById(long id)
			throws Exception {
		return makerCommissionDetailDOMapper.selectByPrimaryKey(id);
	}
	
	public boolean editShopCommissionDO(ShopCommissionDO SCDO) throws Exception {
		
		return shopCommissionDOMapper.updateByPrimaryKeySelective(SCDO)>0;
	}

	
	public boolean editOtherShopCommissionDO(OtherShopCommissionDO OSP)
			throws Exception {
		return otherShopCommissionDOMapper.updateByPrimaryKeySelective(OSP)>0;
	}

	public int removeMakerCommissionDetailDO(long id) throws Exception {
		return makerCommissionDetailDOMapper.deleteByPrimaryKey(id);
	}
	
	public OtherShopCommissionDO queryOtherShopCommissionDOByOtherShopId(
			long otherShopId) throws Exception {
		OtherShopCommissionDOExample example = new OtherShopCommissionDOExample();
		OtherShopCommissionDOExample.Criteria criteria = example.createCriteria();		
		criteria.andOtherShopIdEqualTo(otherShopId);
		criteria.andIsDeleteEqualTo(0);
		return otherShopCommissionDOMapper.selectByExample(example).isEmpty()?null:otherShopCommissionDOMapper.selectByExample(example).get(0);
	}


	public ShopCommissionDO queryShopCommissionDOByShopId(long shopId) {
		ShopCommissionDOExample example = new ShopCommissionDOExample();
		ShopCommissionDOExample.Criteria criteria = example.createCriteria();		
		criteria.andShopIdEqualTo(shopId);
		criteria.andIsDeleteEqualTo(0);
		return shopCommissionDOMapper.selectByPrimaryKey(shopId);
	}
	
	
	public List<HqCommissionDOCustom> queryHqCommissionList(
			HqCommissionQuery query) throws Exception {
		return hqCommissionDOCustomMapper.selectHqCommissionDOList(query);
	}
	public long queryHqCommissionCount(HqCommissionQuery query) throws Exception {
		return hqCommissionDOCustomMapper.selectHqCommissionDOListCount(query);
	}
	
	public List<ShopCommissionDOCustom> queryShopCommissionDOList(
			ShopCommissionQuery query) {
		return shopCommissionDOCustomMapper.selectShopCommissionDOList(query);
	}
	public long queryShopCommissionDOListCount(ShopCommissionQuery query) {
		return shopCommissionDOCustomMapper.selectShopCommissionDOListCount(query);
	}
	
	public List<OtherShopCommissionDOCustom> queryOtherShopCommissionDOList(
			OtherShopCommissionQuery query) {
		return otherShopCommissionDOCustomMapper.selectOtherShopCommissionDOList(query);
	}
	public long queryOtherShopCommissionDOListCount(OtherShopCommissionQuery query) {
		return otherShopCommissionDOCustomMapper.selectOtherShopCommissionDOListCount(query);
	}

}
