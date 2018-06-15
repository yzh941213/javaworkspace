package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.dao.IWareDao;
import com.web.entity.Ware;
import com.web.service.IWareService;

public class WareServiceImpl implements IWareService {
	private IWareDao wareDao;
	
	public void setWareDao(IWareDao wareDao) {
		this.wareDao = wareDao;
	}

	public List<Ware> getWare(String type) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("type", type);
		return wareDao.getWare(map);
	}

	public Ware getWareByID(Integer wareAutoid) {
		return wareDao.getWareByID(wareAutoid);
	}

	public int modify(Ware ware) {
		return wareDao.modify(ware);
	}

}
