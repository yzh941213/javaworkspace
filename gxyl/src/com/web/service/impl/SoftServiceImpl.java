package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.common.Tools;
import com.web.dao.ISoftDao;
import com.web.entity.Soft;
import com.web.service.ISoftService;

public class SoftServiceImpl implements ISoftService {
	private ISoftDao softDao;
	
	public void setSoftDao(ISoftDao softDao) {
		this.softDao = softDao;
	}

	public Soft create(Soft soft) {
		int result=softDao.create(soft);
		Integer softAutoid=soft.getSoftAutoid();
		return getSoftByID(softAutoid);
	}

	public int delete(String autoids) {
		int[] ids=Tools.toArray(autoids, ",");
		return softDao.delete(ids);
	}

	public Soft getSoftByID(Integer softAutoid) {
		if(softAutoid!=0){
			return softDao.getSoftByID(softAutoid);
		}
		return null;
	}

	public Model<Soft> getSoftByPage(int pageindex, int pagesize, int clsID) {
		Map<String, Object> map=new HashMap<String, Object>();
		pageindex=(pageindex-1)*pagesize;
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("clsID", clsID);
		List<Soft> list=softDao.getSoftByPage(map);
		int count=softDao.getCount(map);
		Model<Soft> model=new Model<Soft>(list, count);
		return model;
	}

	public int modify(Soft soft) {
		return softDao.modify(soft);
	}

}
