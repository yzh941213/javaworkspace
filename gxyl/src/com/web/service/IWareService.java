package com.web.service;

import java.util.List;

import com.web.entity.Ware;

public interface IWareService {
	Ware getWareByID(Integer wareAutoid);
	List<Ware> getWare(String type);
	int modify(Ware ware);
}
