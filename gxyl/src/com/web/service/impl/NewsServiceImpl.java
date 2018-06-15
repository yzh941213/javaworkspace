package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.common.Tools;
import com.web.dao.IAttachDao;
import com.web.dao.INewsDao;
import com.web.entity.Attach;
import com.web.entity.News;
import com.web.service.INewsService;

public class NewsServiceImpl implements INewsService {
	private INewsDao newsDao;

	public void setNewsDao(INewsDao newsDao) {
		this.newsDao = newsDao;
	}

	private IAttachDao attachDao;
	
	public void setAttachDao(IAttachDao attachDao) {
		this.attachDao = attachDao;
	}

	public News create(News news, List<Attach> list) {
		int result=newsDao.create(news);
		if(result>0){
			if(list!=null&&list.size()>0){
				for(Attach attach:list){
					attach.setNewsAutoid(news.getNewsAutoid());
				}
				attachDao.create(list);
			}
			return getNewsByID(news.getNewsAutoid());
		}
		return null;
	}

	public int delete(String autoids) {
		int[] ids=Tools.toArray(autoids, ",");
		if(ids!=null){
			for(int newsAutoid:ids){
				attachDao.delete(newsAutoid);
			}
		}
		return newsDao.delete(ids);
	}

	public News getNewsByID(Integer newsAutoid) {
		return newsDao.getNewsByID(newsAutoid);
	}

	public Model<News> getNewsByPage(int pageindex, int pagesize, int newsClsAutoid, String clsName, String title) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("newsClsAutoid", newsClsAutoid);
		map.put("clsName", clsName);
		map.put("title", title);
		List<News> list=newsDao.getNewsByPage(map);
		int count=newsDao.getCount(map);
		Model<News> model=new Model<News>(list, count);
		return model;
	}

	public int modify(News news, List<Attach> list) {
		int result=newsDao.modify(news);
		if(result!=0){
			attachDao.delete(news.getNewsAutoid());
			if(list!=null&&list.size()>0){
				/*for(Attach attach:list){
					attach.setNewsAutoid(news.getNewsAutoid());
				}*/
				attachDao.create(list);
			}
		}
		return result;
	}

	public int setShowIndex(Integer newsClsAutoid, Integer newsAutoid) {
		newsDao.cencalShowIndex(newsClsAutoid);
		return newsDao.setShowIndex(newsAutoid);
	}

	public List<News> getNewsByClsNum(String clsName, int number) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("clsName", clsName);
		map.put("number", number);
		return newsDao.getNewsByClsNum(map);
	}
	public List<News> getNewsByNewsClsAutoid(Integer newsClsAutoid){
		return newsDao.getNewsByNewsClsAutoid(newsClsAutoid);
	}

	public News getNewsByShowIndex(String clsName) {
		return newsDao.getNewsByShowIndex(clsName);
	}
}
