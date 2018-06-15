package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Soft;

public interface ISoftDao {
	int create(Soft soft);
	Soft getSoftByID(Integer softAutoid);
	List<Soft> getSoftByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	int modify(Soft soft);
	int delete(int[] autoids);
}
