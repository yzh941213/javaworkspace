package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.News;

public interface INewsDao {
	News getNewsByID(Integer newsAutoid);
	List<News> getNewsByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	int create(News news);
	int modify(News news);
	int delete(int[] autoids);
	
	int setShowIndex(Integer newsAutoid);
	int cencalShowIndex(Integer newsClsAutoid);
	
	List<News> getNewsByClsNum(Map<String, Object> map);
	
	List<News> getNewsByNewsClsAutoid(Integer newsClsAutoid);
	
	News getNewsByShowIndex(String clsName);
}
