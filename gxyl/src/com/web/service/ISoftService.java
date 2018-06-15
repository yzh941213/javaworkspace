package com.web.service;

import com.common.Model;
import com.web.entity.Soft;

public interface ISoftService {
	Soft create(Soft soft);
	Soft getSoftByID(Integer softAutoid);
	Model<Soft> getSoftByPage(int pageindex, int pagesize,int clsID);
	int delete(String autoids);
	int modify(Soft soft);
}
