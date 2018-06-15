package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.NewsCls;

public interface INewsClsDao {
	NewsCls getNewsClsByID(Integer newsClsAutoid);
	List<NewsCls> getNewsCls(Map<String, Object> map);
	int create(NewsCls newsCls);
	int modify(NewsCls newsCls);
	int delete(Integer newsClsAutoid);
}
