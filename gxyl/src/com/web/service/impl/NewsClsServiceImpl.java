package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.dao.INewsClsDao;
import com.web.entity.NewsCls;
import com.web.service.INewsClsService;

public class NewsClsServiceImpl implements INewsClsService {
	private INewsClsDao newsClsDao;
	
	public void setNewsClsDao(INewsClsDao newsClsDao) {
		this.newsClsDao = newsClsDao;
	}

	public NewsCls create(NewsCls newsCls) {
		int result= newsClsDao.create(newsCls);
		if(result>0){
			return getNewsClsByID(newsCls.getNewsClsAutoid());
		}
		return null;
	}

	public int delete(Integer newsClsAutoid) {
		return newsClsDao.delete(newsClsAutoid);
	}

	public NewsCls getNewsClsByID(Integer newsClsAutoid) {
		return newsClsDao.getNewsClsByID(newsClsAutoid);
	}

	public List<NewsCls> getNewsCls(String clsName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("clsName", clsName);
		return newsClsDao.getNewsCls(map);
	}

	public int modify(NewsCls newsCls) {
		return newsClsDao.modify(newsCls);
	}
	
}
