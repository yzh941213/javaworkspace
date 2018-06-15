package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Ware;

public interface IWareDao {
	Ware getWareByID(Integer wareAutoid);
	List<Ware> getWare(Map<String, Object> map);
	int modify(Ware ware);
}
