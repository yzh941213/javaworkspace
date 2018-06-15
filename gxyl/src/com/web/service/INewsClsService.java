package com.web.service;

import java.util.List;

import com.web.entity.NewsCls;

public interface INewsClsService {
	NewsCls getNewsClsByID(Integer newsClsAutoid);
	List<NewsCls> getNewsCls(String clsName);
	NewsCls create(NewsCls newsCls);
	int modify(NewsCls newsCls);
	int delete(Integer newsClsAutoid);
}
