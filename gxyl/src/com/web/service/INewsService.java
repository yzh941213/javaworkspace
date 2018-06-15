package com.web.service;

import java.util.List;

import com.common.Model;
import com.web.entity.Attach;
import com.web.entity.News;

public interface INewsService {

	News getNewsByID(Integer newsAutoid);
	Model<News> getNewsByPage(int pageindex, int pagesize, int newsClsAutoid,String clsName, String title);
	News create(News news, List<Attach> list);
	int modify(News news, List<Attach> list);
	int delete(String autoids);
	
	int setShowIndex(Integer newsClsAutoid, Integer newsAutoid);
	/**
	 * 通过newcls分类读取一定数量的news
	 * @param clsName
	 * @param number 数量，如果是0，则全读取
	 * */
	List<News> getNewsByClsNum(String clsName, int number);
	
	List<News> getNewsByNewsClsAutoid(Integer newsClsAutoid);
	
	/**返回一个分类下的唯一一个置顶的news*/
	News getNewsByShowIndex(String clsName);
}
